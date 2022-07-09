package top.top102;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，
 * 返回其节点值的 层序遍历 。
 * 即逐层地，从左到右访问所有节点。
 *
 * @Classname Top102
 * @Version 1.0.0
 * @Date 2022/7/9 13:14
 * @Created by sxx_xwl
 */
public class Top102 {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> listList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        add(root, 0);
        return listList;
    }

    private void add(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (listList.size() > index) {
            listList.get(index).add(root.val);
        } else {
            list.add(root.val);
            listList.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        add(root.left, index + 1);
        add(root.right, index + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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
