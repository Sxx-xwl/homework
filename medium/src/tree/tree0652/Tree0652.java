package tree.tree0652;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 * https://leetcode.cn/problems/find-duplicate-subtrees/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0652
 * @create 2022-11-20-12:06
 */
public class Tree0652 {
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
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(" ");
        sb.append(dfs(root.left));
        sb.append(" ");
        sb.append(dfs(root.right));
        String s = sb.toString();
        if (map.containsKey(s)) {
            if (map.get(s) == 1) {
                res.add(root);
            }
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}