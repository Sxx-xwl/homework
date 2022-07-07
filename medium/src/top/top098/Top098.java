package top.top098;


/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @Classname Top098
 * @Version 1.0.0
 * @Date 2022/7/7 15:24
 * @Created by sxx_xwl
 */
public class Top098 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        TreeNode root1 = new TreeNode(0);
        System.out.println(new Solution().isValidBST(root1));
    }
}

class Solution {
    double preValue = Integer.MIN_VALUE - 1.0;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        search(root);
        return isValid;
    }

    private void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        if (root.val <= preValue) {
            isValid = false;
            return;
        }
        preValue = root.val;
        search(root.right);
        return;
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