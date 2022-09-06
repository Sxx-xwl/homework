package top.top287;

/**
 * 给定一个包含n + 1 个整数的数组nums ，
 * 其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top287
 * @create 2022-09-06-21:14
 */
public class Top287 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        int duplicate = new Solution().findDuplicate(nums);
        System.out.println(duplicate);
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = slow;
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}