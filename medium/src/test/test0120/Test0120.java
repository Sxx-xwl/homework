package test.test0120;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * https://leetcode.cn/problems/triangle/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0120
 * @create 2022-12-04-11:09
 */
public class Test0120 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size(), res = Integer.MAX_VALUE;
        int[] arr = new int[len];
        arr[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    arr[j] += cur.get(j);
                } else if (j == i) {
                    arr[j] = cur.get(j) + arr[j - 1];
                } else {
                    arr[j] = Math.min(arr[j], arr[j - 1]) + cur.get(j);
                }
            }
        }
        for (int a : arr) {
            res = Math.min(a, res);
        }
        return res;
    }
}