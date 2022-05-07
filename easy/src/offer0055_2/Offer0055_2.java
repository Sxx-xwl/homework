package offer0055_2;

/**输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 * @author sxx_27
 * @create 2022-05-07 16:37
 */
public class Offer0055_2 {

}

class Solution {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        int right = depth(root.right);
        int left = depth(root.left);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs((right - left)) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
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