package top.top055;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * @Classname Top055
 * @Version 1.0.0
 * @Date 2022/7/4 11:13
 * @Created by sxx_xwl
 */
public class Top055 {
    public static void main(String[] args) {
        int[] nums = {1, 2,0,5,0,0,0,0};
        System.out.println(new Solution().canJump(nums));
    }
}

class Solution {

    public boolean canJump(int[] nums) {
        return nums.length == 1 || (nums[0] != 0 && search(nums, 0, 1));
    }

    private boolean search(int[] nums, int l, int r) {
        int temp = 0;
        if (nums[r] == 0) {
            for (int i = l; i < r; i++) {
                if (r == nums.length - 1 && nums[i] + i == r) {
                    return true;
                }
                if (nums[i] + i > r) {
                    temp = i;
                    break;
                }
                if (i == r - 1) {
                    return false;
                }
            }
        }
        r++;
        for (int i = r; i < nums.length; i++) {
            if (nums[i] == 0) {
                return search(nums, temp, i);
            }
        }
        return true;
    }
}