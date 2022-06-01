package offer.offer0027;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author sxx_27
 * @create 2022-04-30 17:29
 */
public class Offer0027 {

    public static void main(String[] args) {
        System.out.println();
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode preNode = null;
        if (root == null) {
            return preNode;
        }

        TreeNode tempNode = root;

        preNode = tempNode.left;
        tempNode.left = tempNode.right;
        tempNode.right = preNode;
        mirrorTree(tempNode.right);
        mirrorTree(tempNode.left);

        return tempNode;

    }
}