package tree.binarytree0938;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

/**
 * 给定二叉搜索树的根结点 root，
 * 返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0938
 * @create 2022-10-09-11:02
 */
public class Binarytree0938 {
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
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        rangeSumBST(root.left, low, high);
        if (root.val <= high && root.val >= low) {
            res += root.val;
        }
        if (root.val <= high){
            rangeSumBST(root.right, low, high);
        }
        return res;
    }
}