package offer0057_1;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author sxx_27
 * @create 2022-05-07 17:19
 */
public class Offer0057_1 {
    public static void main(String[] args) {

    }
}

class Solution {
    //未排序的适用于
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                return res;
            }
            set.add(nums[i]);
        }
        return res;
    }

    //排序好的适用于
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            }
        }
        return res;
    }
}