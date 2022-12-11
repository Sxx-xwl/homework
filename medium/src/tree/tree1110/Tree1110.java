package tree.tree1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * https://leetcode.cn/problems/delete-nodes-and-return-forest/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1110
 * @create 2022-12-11-14:14
 */
public class Tree1110 {
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
    private Set<Integer> set;
    private List<TreeNode> list;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        list = new ArrayList<>();
        for (int a : to_delete) {
            set.add(a);
        }
        TreeNode temp = new TreeNode(1);
        temp.left = root;
        dfs(root, temp);
        if (!set.contains(root.val)) {
            list.add(root);
        }
        return list;
    }

    private void dfs(TreeNode root, TreeNode preNode) {
        if (root == null) {
            return;
        }
        dfs(root.left, root);
        dfs(root.right, root);
        if (set.contains(root.val)) {
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
            if (preNode.left != null && preNode.left.val == root.val) {
                preNode.left = null;
            } else {
                preNode.right = null;
            }
        }
    }
}