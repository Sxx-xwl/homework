package tree.tree0437;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，
 * 和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，
 * 也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0437
 * @create 2022-11-07-11:11
 */
public class Tree0437 {
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
    int res;
    Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long cur, int targetSum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        res += map.getOrDefault(cur - targetSum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        dfs(root.left, cur, targetSum);
        dfs(root.right, cur, targetSum);
        map.put(cur, map.get(cur) - 1);
    }
//    private void dfs(TreeNode root, long targetSum) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left, targetSum);
//        search(root, targetSum);
//        dfs(root.right, targetSum);
//    }

//    private void search(TreeNode root, long targetSum) {
//        if (root == null) {
//            return;
//        }
//        if (targetSum - root.val == 0) {
//            res++;
//        }
//        search(root.left, targetSum - root.val);
//        search(root.right, targetSum - root.val);
//    }
}