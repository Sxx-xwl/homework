package tree.binarytree0671;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值 。
 * 如果第二小的值不存在的话，输出 -1
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0671
 * @create 2022-09-27-12:43
 */
public class Binarytree0671 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int val = root.val;
        double res = Math.min(search(root.left, val), search(root.right, val));
        return (int) (res == Double.MAX_VALUE ? -1 : res);
    }

    private double search(TreeNode root, int val) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val != val) {
            return root.val;
        }
        return Math.min(search(root.left, val), search(root.right, val));
    }
}