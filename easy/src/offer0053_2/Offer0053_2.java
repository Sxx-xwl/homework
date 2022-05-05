package offer0053_2;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 *
 * @author sxx_27
 * @create 2022-05-05 20:16
 */
public class Offer0053_2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int i = new Solution().missingNumber(arr);
        System.out.println(i);
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int search = search(nums, 0, nums.length - 1);
        return search;
    }

    private int search(int[] nums, int l, int r) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else if (nums[mid] > mid) {
                r = mid - 1;
            }
        }
        return l;
    }
}