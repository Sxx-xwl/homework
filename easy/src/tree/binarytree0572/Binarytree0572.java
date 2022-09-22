package tree.binarytree0572;

/**
 * 给你两棵二叉树 root 和 subRoot 。
 * 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。
 * tree 也可以看做它自身的一棵子树
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0572
 * @create 2022-09-22-21:27
 */
public class Binarytree0572 {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val && search(root, subRoot)) {
                return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean search(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return search(root.left, subRoot.left) && search(root.right, subRoot.right);
    }
}