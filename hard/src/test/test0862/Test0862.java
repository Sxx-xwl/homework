package test.test0862;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 找出 nums 中和至少为 k 的 最短非空子数组 ，
 * 并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * 子数组 是数组中 连续 的一部分
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0862
 * @create 2022-10-26-11:41
 */
public class Test0862 {
    public static void main(String[] args) {
//        int[] nums = {48, 99, 37, 4, -31};
//        System.out.println(new Solution().shortestSubarray(nums, 140));
        int[] nums = new int[]{84, -37, 32, 40, 95};
        System.out.println(new Solution().shortestSubarray(nums, 167));
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length, res = Integer.MAX_VALUE;
        long[] temp = new long[len + 1];
        temp[0] = 0;
        for (int i = 0; i < len; i++) {
            temp[i + 1] = temp[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temp.length; i++) {
            long cur = temp[i] - k;
            while (!deque.isEmpty() && temp[deque.getFirst()] <= cur) {
                res = Math.min(i - deque.getFirst(), res);
                deque.removeFirst();
            }
            while (!deque.isEmpty() && temp[deque.getLast()] > temp[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}