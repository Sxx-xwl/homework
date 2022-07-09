package top.top105;

import java.util.HashMap;

/**
 * 给定两个整数数组preorder 和 inorder，
 * 其中preorder 是二叉树的先序遍历，
 * inorder是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 *
 * @Classname Top105
 * @Version 1.0.0
 * @Date 2022/7/9 13:41
 * @Created by sxx_xwl
 */
public class Top105 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode treeNode = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return add(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode add(int[] pre, int pre_l, int pre_r, int ino_l) {
        if (pre_l > pre_r) {
            return null;
        }
        int pre_root = pre[pre_l];
        int ino_root = map.get(pre_root);
        TreeNode root = new TreeNode(pre_root);
        int size = ino_root - ino_l;

        root.left = add(pre, pre_l + 1, pre_l + size, ino_l);
        root.right = add(pre, pre_l + 1 + size, pre_r, ino_root + 1);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
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
