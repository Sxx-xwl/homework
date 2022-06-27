package top.top033;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，
 * 如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @Classname Top033
 * @Version 1.0.0
 * @Date 2022/6/27 10:47
 * @Created by sxx_xwl
 */
public class Top033 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr1 = {1, 4};
        int[] arr2 = {5, 1, 4};
        System.out.println(new Solution().search(arr2, 4));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return two(nums, 0, nums.length - 1, target);
    }

    private int two(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < nums[r]) {
            if (nums[mid] < target && nums[r] >= target) {
                return two(nums, mid + 1, r, target);
            } else {
                return two(nums, l, mid - 1, target);
            }
        } else {
            if (nums[mid] > target && nums[l] <= target) {
                return two(nums, l, mid - 1, target);
            } else {
                return two(nums, mid + 1, r, target);
            }
        }
    }
}