package test.test598;

/**
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，
 * 其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时，
 * M[x][y] 应该加 1。
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * https://leetcode.cn/problems/range-addition-ii/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0598
 * @create 2022-12-10-13:59
 */
public class Test598 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int l = m, r = n;
        for (int[] a : ops) {
            l = Math.min(l, a[0]);
            r = Math.min(r, a[1]);
        }
        return l * r;
    }
}