package tree.bianrytree0653;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，
 * 如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，
 * 则返回 true。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.bianrytree0653
 * @create 2022-09-26-20:55
 */
public class Bianrytree0653 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new Solution().findTarget(root, 4));
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
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean l = findTarget(root.left, k);
        if (l || set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return l || findTarget(root.right, k);
    }
}