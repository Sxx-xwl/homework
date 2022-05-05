package offer0028;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author sxx_27
 * @create 2022-04-30 17:53
 */
public class Offer0028 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(new Solution().isSymmetric(root));
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
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        return traverse(left, right);

    }

    private boolean traverse(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        } else if (leftNode.val != rightNode.val) {
            return false;
        }

        boolean l = traverse(leftNode.left, rightNode.right);
        boolean r = traverse(leftNode.right, rightNode.left);
        if (r && l) {
            return true;
        } else {
            return false;
        }
    }
}