package tree.binarytree0094;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root，返回它的中序遍历 。
 *
 * @author sxx_27
 * @create 2022-05-06 16:26
 */
public class Binarytree0094 {

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
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }
}