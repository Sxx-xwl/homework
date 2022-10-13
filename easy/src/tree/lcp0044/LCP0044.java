package tree.lcp0044;

import java.util.HashSet;
import java.util.Set;

/**
 * 「力扣挑战赛」开幕式开始了，
 * 空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，
 * 节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.lcp0044
 * @create 2022-10-13-10:43
 */
public class LCP0044 {
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
    Set<Integer> set;

    public int numColor(TreeNode root) {
        set = new HashSet();
        dfs(root);
        return set.size();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        set.add(root.val);
        dfs(root.right);
    }
}