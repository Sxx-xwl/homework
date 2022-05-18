package offer0033;

import java.util.Queue;
import java.util.Stack;

/**
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同
 *
 * @author sxx_27
 * @create 2022-05-18 14:56
 */
public class Offer0033 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean verifyPostorder0(int[] postorder) {
        int len = postorder.length;
        if (len == 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 1) {
            return true;
        }
        return search(postorder, 0, postorder.length - 1);
    }

    private boolean search(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int p = l;
        while (postorder[p] < postorder[r]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[r]) {
            p++;
        }
        return p == r && search(postorder, l, m - 1) && search(postorder, m, r - 1);
    }
}