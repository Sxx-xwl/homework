package tree.tree0655;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、
 * 大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。
 * 构造此格式化布局矩阵需要遵循以下规则：
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，
 * 将其左子节点放置在 res[r+1][c-2height-r-1] ，
 * 右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * https://leetcode.cn/problems/print-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0655
 * @create 2022-11-22-13:54
 */
public class Tree0655 {
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
    private List<List<String>> listList;
    private int height, n;

    public List<List<String>> printTree(TreeNode root) {
        listList = new LinkedList<>();
        height = getHeight(root);
        n = (1 << height) - 1;
        for (int i = 0; i < height; i++) {
            List<String> temp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                temp.add("");
            }
            listList.add(temp);
        }
        addEle(root, 0, (n - 1) / 2);
        return listList;
    }

    private void addEle(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        List<String> list = listList.get(x);
        list.set(y, String.valueOf(root.val));
        addEle(root.left, x + 1, y - (1 << (height - x - 2)));
        addEle(root.right, x + 1, y + (1 << (height - x - 2)));
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}