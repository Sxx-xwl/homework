package tree.tree0894;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，
 * 并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 * https://leetcode.cn/problems/all-possible-full-binary-trees/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0894
 * @create 2022-12-02-10:49
 */
public class Tree0894 {
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

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) {
            return res;
        }
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode cur : left) {
                for (TreeNode rcur : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = cur;
                    root.right = rcur;
                    res.add(root);
                }
            }
        }
        return res;
    }
}