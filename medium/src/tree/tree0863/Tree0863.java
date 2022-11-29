package tree.tree0863;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
 * 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
 * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0863
 * @create 2022-11-29-13:41
 */
public class Tree0863 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3,
//                new TreeNode(5,
//                        new TreeNode(6),
//                        new TreeNode(2,
//                                new TreeNode(7),
//                                new TreeNode(4))),
//                new TreeNode(1,
//                        new TreeNode(0),
//                        new TreeNode(8)));
        TreeNode root = new TreeNode(0,
                new TreeNode(2),
                new TreeNode(1, new TreeNode(3), null));
        System.out.println(new Solution().distanceK(root, new TreeNode(3), 3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    private Map<TreeNode, TreeNode> map;
    private TreeNode tarNode;
    private List<Integer> list;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        list = new LinkedList<>();
        tarNode = target;
        preOrder(root, null);
        getTarget(tarNode, k, null);
        TreeNode temp = map.get(tarNode);
        TreeNode pre = tarNode;
        int index = 1;
        while (temp != null) {
            getTarget(temp, k - index++, pre);
            pre = temp;
            temp = map.get(temp);
        }
        return list;
    }

    private void getTarget(TreeNode root, int height, TreeNode pre) {
        if (root == null || height < 0 || root== pre) {
            return;
        }
        if (height == 0) {
            list.add(root.val);
            return;
        }
        getTarget(root.left, height - 1, pre);
        getTarget(root.right, height - 1, pre);
    }

    private void preOrder(TreeNode root, TreeNode preNode) {
        if (root == null) {
            return;
        }
        if (root.val == tarNode.val) {
            tarNode = root;
            map.put(root, preNode);
            return;
        }
        map.put(root, preNode);
        preOrder(root.left, root);
        preOrder(root.right, root);
    }
}