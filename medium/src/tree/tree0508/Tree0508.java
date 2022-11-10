package tree.tree0508;

import java.util.*;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。
 * 如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0508
 * @create 2022-11-10-12:40
 */
public class Tree0508 {
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
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        countSum(root);
        int counts = list.size(), index = 0;
        int[] res = new int[counts];
        for (int a : list) {
            res[index++] = a;
        }
        return res;
    }

    private int countSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lval = countSum(root.left);
        int rval = countSum(root.right);
        root.val += lval + rval;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int cur = map.get(root.val);
        if (cur > max) {
            max = cur;
            list.clear();
            list.add(root.val);
        } else if (cur == max) {
            list.add(root.val);
        }
        return root.val;
    }
}