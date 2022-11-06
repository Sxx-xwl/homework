package tree.tree0199;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree199
 * @create 2022-10-27-13:38
 */
public class Tree199 {
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
    private List<Integer> list;

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        midOrder(root, 0);
        return list;
    }

    private void midOrder(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (index < list.size()) {
            list.set(index, root.val);
        } else {
            list.add(root.val);
        }
        midOrder(root.left, index + 1);
        midOrder(root.right, index + 1);
    }
}