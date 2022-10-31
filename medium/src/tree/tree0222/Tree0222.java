package tree.tree0222;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0222
 * @create 2022-10-31-11:38
 */
public class Tree0222 {
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //记录左右子树最左侧的深度
        int lCount = getDepth(root.left);
        int rCount = getDepth(root.right);
        //如果左右深度相等，那左边一定是满二叉树，否则右边一定是满二叉树
        //满二叉树即可用 1<<depth计算其节点数
        if (lCount == rCount) {
            return (1 << lCount) + countNodes(root.right);
        } else {
            return (1 << rCount) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}