package tree.tree0538;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0538
 * @create 2022-11-17-15:12
 */
public class Tree0538 {
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
    private int value;

    public TreeNode convertBST(TreeNode root) {
        value = 0;
        nextOrder(root);
        return root;
    }

    private void nextOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        nextOrder(root.right);
        root.val += value;
        value = root.val;
        nextOrder(root.left);
    }
}