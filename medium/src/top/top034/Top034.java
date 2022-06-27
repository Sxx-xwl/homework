package top.top034;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 *
 * @Classname Top034
 * @Version 1.0.0
 * @Date 2022/6/27 11:32
 * @Created by sxx_xwl
 */
public class Top034 {
    public static void main(String[] args) {
        int[] arr ={5,7,7,8,8,10};
        System.out.println(Arrays.toString(new Solution().searchRange(arr, 5)));
    }
}

class Solution {
    int[] res = {-1,-1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return res;
        }
        binarySearch1(nums, 0, nums.length - 1, target,true);
        binarySearch1(nums, 0, nums.length - 1, target,false);
        return res;
    }

    private void binarySearch1(int[] nums, int l, int r, int target,boolean isL) {
        if (l > r) {
            return;
        }
        int mid = l + (r - l) / 2;
        if (isL){
            if (nums[mid] >= target){
                if (nums[mid]==target){
                    res[0] = mid;
                }
                binarySearch1(nums,l,mid-1,target,isL);
            }else {
                binarySearch1(nums,mid+1,r,target,isL);
            }
        }else {
            if (nums[mid] <= target){
                if (nums[mid]==target){
                    res[1] = mid;
                }
                binarySearch1(nums,mid+1,r,target,isL);
            }else {
                binarySearch1(nums,l,mid-1,target,isL);
            }
        }
    }
    private void binarySearch2(int[] nums, int l, int r, int target) {
        if (l > r) {
            return;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] <= target){
            if (nums[mid]==target){
                res[1] = mid;
            }
            binarySearch2(nums,mid+1,r,target);
        }else {
            binarySearch2(nums,l,mid-1,target);
        }
    }
}