package tree.tree0106;

import javax.sound.sampled.Port;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0106
 * @create 2022-10-19-12:44
 */
public class Tree0106 {
    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
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
    private int rootIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        return postTrree(inorder, postorder, 0, rootIndex);
    }

    private TreeNode postTrree(int[] inorder, int[] postorder, int inl, int inr) {
        if (inl > inr) {
            return null;
        }
        int rootVal = postorder[rootIndex--];
        int mid = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i = inl; i <= inr; i++) {
            if (inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }
        root.right = postTrree(inorder, postorder, mid + 1, inr);
        root.left = postTrree(inorder, postorder, inl, mid - 1);
        return root;
    }
}