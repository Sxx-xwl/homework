package tree.binarytree0637;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点 root ,
 * 以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10-5 以内的答案可以被接受。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.bianrytree0637
 * @create 2022-09-24-22:50
 */
public class Bianrytree0637 {
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
    List<Double> list;
    List<Integer> counts;

    public List<Double> averageOfLevels(TreeNode root) {
        list = new ArrayList<>();
        counts = new ArrayList<>();
        search(root, 0);
        for (int i = 0; i < list.size(); i++) {
            double v = list.get(i) / counts.get(i);
            list.set(i, v);
        }
        return list;
    }

    private void search(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (list.size() < index + 1) {
            list.add(root.val / 1.0);
            counts.add(1);
        } else {
            list.set(index, list.get(index) + root.val);
            counts.set(index, counts.get(index) + 1);
        }
        search(root.left, index + 1);
        search(root.right, index + 1);
    }
}