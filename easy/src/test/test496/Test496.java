package test.test496;

import java.util.*;

/**
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test496
 * @create 2022-10-21-18:08
 */
public class Test496 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = -1;
            map.put(nums1[i], i);
        }
        for (int i = len2 - 1; i >= 0; i--) {
            int temp = nums2[i];
            while (!stack.isEmpty() && stack.peek() < temp) {
                stack.pop();
            }
            if (!stack.isEmpty() && map.containsKey(temp)) {
                res[map.get(temp)] = stack.peek();
            }
            stack.push(temp);
        }
        return res;
    }
}