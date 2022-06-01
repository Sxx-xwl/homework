package offer.offer0021;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * @author sxx_27
 * @create 2022-04-29 19:29
 */
public class Offer0021 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().exchange(nums)));
    }
}

class Solution {
    public int[] exchange0(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&1)==1) {
                swap(nums, target++, i);
            }
        }

        return nums;
    }
    public int[] exchange(int[] nums) {
        int len = nums.length;

        int r = 0;
        int target = 0;
        while (target < len) {
            if ((nums[target]&1)==1) {
                swap(nums, r++, target++);
            } else {
                target++;
            }
        }

        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}