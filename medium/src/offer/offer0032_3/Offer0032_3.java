package offer.offer0032_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 *
 * @author sxx_27
 * @create 2022-05-18 14:19
 */
public class Offer0032_3 {
    public static void main(String[] args) {

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
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        add(root, 0, 0);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    private void add(TreeNode root, int index, int num) {
        if (root == null) {
            return;
        }
        if (list.size() <= index) {
            List<Integer> res = new ArrayList<>();
            list.add(res);
        }
        list.get(index).add(root.val);
        add(root.left, index + 1, num + 1);
        add(root.right, index + 1, num + 1);
    }
}