package test0034;

import java.util.ArrayList;

/**给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 如果数组中不存在目标值 target，返回[-1, -1]。
 * @author sxx_27
 * @create 2022-03-16 20:23
 */

public class Test0034 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {5,7,7,8,8,10};
//        int arr[] = {1};
//        int arr[] = {1,1};
        int[] ints = s.searchRange(arr, 10);
        for (int i : ints)
        {
            System.out.print(i + ",");
        }
    }

}


class Solution {
    public int[] searchRange(int[] nums, int target) {

        //flag = true  查找第一个
        int lIndex = binarySearch(nums, target, true);
        //flag = false  查找最后一个
        int rIndex = binarySearch(nums, target, false);

        return new int[]{lIndex, rIndex};
    }

    public int binarySearch(int[] arr, int target, boolean flag) {

        int l = 0;
        int r = arr.length - 1;
        int m;
        int temp = -1; //记录位置
        while (l <= r) {
            m = (l + r) >> 1;
            if (arr[m] > target) {
                r = m - 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else if (flag) {//相等的同时  找第一个所以往左查找
                temp = m;
                r = m - 1;
            } else {//相等的同时  找最后一个所以往右查找
                temp = m;
                l = m + 1;
            }
        }
        return temp;
    }


    public int[] searchRange0(int[] nums, int target) {

        int arr[] = {-1, -1};
        int i = 0;
        boolean flag = true;
        while (i < nums.length) {
            if (flag && nums[i] == target) {
                arr[0] = i;
                flag = false;
                if (i == nums.length - 1) {
                    arr[1] = i;
                }
            } else if (!flag && nums[i] != target) {
                arr[1] = i - 1;
                break;
            } else if (!flag && i == nums.length - 1) {
                arr[1] = i;
            }
            i++;
        }
        return arr;
    }
}