package tree.tree0235;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0235
 * @create 2022-11-01-15:12
 */
public class Tree0235 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode l = null, r = null;
        if (root.val >= Math.min(q.val, p.val)) {
            l = lowestCommonAncestor(root.left, p, q);
        }
        if (root.val <= Math.max(q.val, p.val)) {
            r = lowestCommonAncestor(root.right, p, q);
        }
        if (l != null && r != null) {
            return root;
        }
        return l == null ? r : l;
    }
}