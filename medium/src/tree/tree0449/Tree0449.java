package tree.tree0449;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，
 * 以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，
 * 以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。
 * 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，
 * 并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0449
 * @create 2022-11-08-12:42
 */
public class Tree0449 {
    public static void main(String[] args) {
//        TreeNode root = null;
//        TreeNode root = new TreeNode(2, new TreeNode(1), null);
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        String serialize = new Codec().serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = new Codec().deserialize(serialize);
        System.out.println(deserialize);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//class Codec {
//
//    private StringBuilder preOrder;
//    private Map<String, Integer> map;
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        preOrder = new StringBuilder();
//        search(root);
////        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(preOrder.toString());
//        return preOrder.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.isEmpty()) return null;
//        map = new HashMap<>();
////        data = "41,37,24,1,0,2,4,3,9,7,6,5,8,11,10,16,15,12,13,14,19,18,17,20,22,21,23,35,30,29,26,25,27,28,32,31,34,33,36,39,38,40,44,42,43,48,46,45,47,49,";
//        String[] preStr = data.split(",");
//        String[] inStr = Arrays.copyOf(preStr, preStr.length);
//        Arrays.sort(inStr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int a = Integer.parseInt(o1);
//                int b = Integer.parseInt(o2);
//                return a - b;
//            }
//        });
//        for (int i = 0; i < inStr.length; i++) {
//            map.put(inStr[i], i);
//        }
//        TreeNode root = deserialize(preStr, 0, preStr.length - 1, 0);
//        return root;
//    }
//
//    private TreeNode deserialize(String[] preStr, int pre_l, int pre_r, int ino_l) {
//        if (pre_l > pre_r) {
//            return null;
//        }
//        String pre_root = preStr[pre_l];
//        int root_index = map.get(pre_root);
//        TreeNode root = new TreeNode(Integer.parseInt(pre_root));
//        int size = root_index - ino_l;
//        root.left = deserialize(preStr, pre_l + 1, pre_l + size, ino_l);
//        root.right = deserialize(preStr, pre_l + size + 1, pre_r, root_index + 1);
//        return root;
//    }
//
//    private void search(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        preOrder.append(root.val).append(",");
//        search(root.left);
//        search(root.right);
//    }
//}

class Codec {

    private StringBuilder sb;
    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        search(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] split = data.split(",");
        TreeNode root = deserialize(split);
        return root;
    }

    private TreeNode deserialize(String[] data) {
        if (index >= data.length) {
            return null;
        }
        if (data[index].equals("!")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }

    private void search(TreeNode root) {
        if (root == null) {
            sb.append('!').append(',');
            return;
        }
        sb.append(root.val).append(",");
        search(root.left);
        search(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;