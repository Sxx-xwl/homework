package tree.offerII0056;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
 * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
 * 假设二叉搜索树中节点的值均唯一。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.offerII0056
 * @create 2022-10-14-10:32
 */
public class OfferII0056 {
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
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean l = findTarget(root.left, k);
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        boolean r = findTarget(root.right, k);
        return l || r;
    }
}