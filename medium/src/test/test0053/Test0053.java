package test.test0053;

/**
 * 给你一个整数数组 nums ，
 * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * @author sxx_27
 * @create 2022-04-01 17:05
 */
public class Test0053 {


    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {0, -4, 5, -4, 8};
        int i = s.maxSubArray(arr);
        System.out.println(i);

    }
}

//class Solution {
//    public int maxSubArray(int[] nums) {
//        int res = nums[0];
//        int cur = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < 0) {
//                cur = (nums[i] + cur) < 0 ? nums[i] : (nums[i] + cur);
//            } else {
//                if (cur < 0) {
//                    cur = nums[i];
//                } else {
//                    cur += nums[i];
//                }
//            }
//            res = Math.max(res, cur);
//        }
//        return res;
//    }
//}
class Solution {
    public int maxSubArray(int[] nums) {
        int count = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0)
            {
                sum = 0;
            }
            sum += nums[i];
            count = Math.max(sum, count);
        }
        return count;
    }
}