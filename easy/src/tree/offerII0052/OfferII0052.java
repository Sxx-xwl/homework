package tree.offerII0052;

/**
 * 给你一棵二叉搜索树，
 * 请 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.offerII0052
 * @create 2022-10-13-10:48
 */
public class OfferII0052 {
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
    TreeNode temp, head;

    public TreeNode increasingBST(TreeNode root) {
        temp = new TreeNode(Integer.MIN_VALUE);
        head = temp;
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        dfs(root.right);
    }
}