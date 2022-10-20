package tree.tree0107;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0107
 * @create 2022-10-20-11:22
 */
public class Tree0107 {
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
    private List<List<Integer>> list;
    private int maxDep;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        maxDep = maxDep(root);
        list = new ArrayList<>(maxDep);
        for (int i = 0; i < maxDep; i++) {
            list.add(new ArrayList<>());
        }
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        dfs(root.left, index + 1);
        int temp = maxDep - index - 1;
        List<Integer> tempList = this.list.get(temp);
        tempList.add(root.val);
        dfs(root.right, index + 1);
    }

    private int maxDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDep(root.left), maxDep(root.right)) + 1;
    }
}