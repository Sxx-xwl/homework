package tree.tree0337;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0175
 * @create 2022-11-03-11:11
 */
public class Tree0337 {
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
    Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return search(root);
    }

    private int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int cur = root.val;
        if (root.left != null) {
            cur += search(root.left.left) + search(root.left.right);
        }
        if (root.right != null) {
            cur += search(root.right.right) + search(root.right.left);
        }
        int res = Math.max(cur, search(root.left) + search(root.right));
        map.put(root, res);
        return res;
    }
}