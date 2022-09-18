package tree.binarytree0501;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，
 * 找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0501
 * @create 2022-09-18-23:11
 */
public class Binarytree0501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(Arrays.toString(new Solution().findMode(root)));
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    int maxCount = 0, curNum = Integer.MIN_VALUE, times = 0;

    public int[] findMode(TreeNode root) {
        search(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        update(root.val);
        search(root.right);
    }

    private void update(int val) {
        if (val != curNum) {
            curNum = val;
            times = 0;
        }
        times++;
        if (maxCount < times) {
            maxCount = times;
            list.clear();
            list.add(val);
        } else if (maxCount == times) {
            list.add(val);
        }
    }
}

class Solution0 {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        search(root, Integer.MIN_VALUE, 0);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void search(TreeNode root, int num, int times) {
        if (root == null) {
            return;
        }
        search(root.left, num, times);
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        search(root.right, num, times);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}