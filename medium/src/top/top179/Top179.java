package top.top179;

import java.util.*;

/**
 * 给定一组非负整数 nums，
 * 重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，
 * 所以你需要返回一个字符串而不是整数。
 *
 * @Classname Top179
 * @Version 1.0.0
 * @Date 2022/7/19 13:28
 * @Created by sxx_xwl
 */
public class Top179 {
    public static void main(String[] args) {
        int[] nums = {30, 2, 3, 31, 34, 5, 9};
        System.out.println(new Solution().largestNumber(nums));
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
//        int len = nums.length;
//        String[] str = new String[len];
//        for (int i = 0; i < len; i++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
//        if ("0".equals(str[0])) {
//            return "0";
//        }
//        for (int i = 0; i < len; i++) {
//            sb.append(str[i]);
//        }
        quickSort(nums, 0, nums.length - 1);
        if (0 == nums[0]){
            return "0";
        }
        for (int a : nums){
            sb.append(a);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (pivot >= x) {
                x *= 10;
            }
            while (nums[i] >= y) {
                y *= 10;
            }
            if (pivot * y + nums[i] < pivot + nums[i] * x) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums,start,index);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}