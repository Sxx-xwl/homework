package tree.tree0662;

import javafx.scene.transform.Rotate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，
 * 这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0662
 * @create 2022-11-23-13:35
 */
public class Tree0662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        null),
                new TreeNode(2));
        System.out.println(new Solution().widthOfBinaryTree(root));
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
    private int res = 0;

    public int widthOfBinaryTree(TreeNode root) {
        list = new LinkedList<>();
        search(root, 0, 1);
        return res;
    }

    private void search(TreeNode root, int height, int index) {
        if (root == null) {
            return;
        }
        if (list.size() < height + 1) {
            list.add(index);
        } else {
            int num = list.get(height);
            res = Math.max(index - num + 1, res);
        }
        search(root.left, height + 1, 2 * index);
        search(root.right, height + 1, 2 * index + 1);
    }
}