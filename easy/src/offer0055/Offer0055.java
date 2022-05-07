package offer0055;

/**输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度
 * @author sxx_27
 * @create 2022-05-06 19:25
 */
public class Offer0055 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        search0(root, 0);
        return max;
    }

    private void search0(TreeNode root, int num) {
        if (root == null) {
            max = Math.max(max , num);
            return;
        }
        num++;
        search0(root.left, num);
        search0(root.right, num);
    }
}