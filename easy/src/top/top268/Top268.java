package top.top268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，
 * 找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * @author sxx_xwl
 * @create 2022-06-20-20:35
 */
public class Top268 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int r = nums.length - 1;
        int l = 0;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res^nums.length;
    }
}