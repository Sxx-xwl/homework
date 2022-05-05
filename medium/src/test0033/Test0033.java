package test0033;

/**整数数组 nums 按升序排列，数组中的值 互不相同 。
 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * @author sxx_27
 * @create 2022-03-15 20:57
 */
public class Test0033 {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        int arr[] = {4,5,6,7,8,1,2,3};
//        int arr[] = {3,5,1};1
//        int arr[] = {3,1};
//        int arr[] = {1,3};0
//        int arr[] = {2,3,4,5,1};1
        int arr[] = {4,5,6,7,0,1,2};
        int search = solution.search1(arr,0);
        System.out.println(search);

    }
}

class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int r = nums.length - 1;
        int l = 0;
        int mid = (r + l) >> 1;

        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            } else if (mid > 0 && nums[mid] > target && nums[mid - 1] < nums[mid]) {
                if (nums[l] > target && nums[mid] >= nums[l]) {
                    l = mid + 1;
                    mid = (r + l) >> 1;
                } else {
                    r = mid - 1;
                    mid = (r + l) >> 1;
                }

            } else if (mid < nums.length - 1 && nums[mid] < target && nums[mid + 1] > nums[mid]) {
                if (nums[r] < target && nums[mid] <= nums[r]) {
                    r = mid - 1;
                    mid = (r + l) >> 1;
                } else {
                    l = mid + 1;
                    mid = (r + l) >> 1;
                }
            } else {
                if (nums[l] == target) {
                    return l;
                } else if (nums[r] == target) {
                    return r;
                }
                return -1;
            }
        }
        return -1;
    }
    public int search1(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int r = nums.length - 1;
        int l = 0;
        int mid = (r + l) >> 1;

        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                mid = (r + l) >> 1;
            } else {
                if (nums[r] >= target && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                mid = (r + l) >> 1;
            }
        }
        return -1;
    }
    public int search0(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
