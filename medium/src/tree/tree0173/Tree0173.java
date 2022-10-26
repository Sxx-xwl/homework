package tree.tree0173;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0173
 * @create 2022-10-26-10:29
 */
public class Tree0173 {
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

class BSTIterator {
    private int[] temp;
    private int index, hight;

    public BSTIterator(TreeNode root) {
        index = 0;
        getHight(root);
        hight = index;
        temp = new int[hight];
        index = 0;
        midOrder(root);
        index = 0;
    }

    public int next() {
        return temp[index++];
    }

    public boolean hasNext() {
        return index < hight;
    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        temp[index++] = root.val;
        midOrder(root.right);
    }

    private void getHight(TreeNode root) {
        if (root == null) {
            return;
        }
        getHight(root.left);
        index++;
        getHight(root.right);
    }
}