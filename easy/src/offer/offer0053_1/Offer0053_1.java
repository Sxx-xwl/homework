package offer.offer0053_1;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author sxx_27
 * @create 2022-05-05 17:11
 */
public class Offer0053_1 {

    public static void main(String[] args) {

        int[] arr = {1, 5, 8, 8, 8, 10};
        int search = new Solution().search(arr, 8);
        System.out.println(search);
    }
}

class Solution {
    public int search0(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            } else if (nums[i] > target) {
                return res;
            }
        }
        return res;
    }

    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        while (left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                while (nums[hi] != target) {
                    hi--;
                }
                while (nums[lo] != target) {
                    lo++;
                }
                    break;
            }
        }
        return hi - lo + 1;
    }
}