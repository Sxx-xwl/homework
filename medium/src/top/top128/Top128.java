package top.top128;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * @Classname Top128
 * @Version 1.0.0
 * @Date 2022/7/10 14:57
 * @Created by sxx_xwl
 */
public class Top128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 1, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}

class Solution {
    public int longestConsecutive0(int[] nums) {
        Arrays.sort(nums);
        int now = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                now++;
                max = Math.max(now, max);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                now = 1;
            }
        }
        return max;
    }

    public int longestConsecutive(int[] nums) {
        int max = 1, temp = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int index = 0;
        while (index < nums.length) {
            int t = nums[index];
            if (!set.contains(t-1)){
                while (set.contains(t)) {
                    set.remove(t);
                    t++;
                    temp++;
                    max = Math.max(max, temp);
                }
            }
            temp = 0;
            index++;
        }
        return max;
    }
}