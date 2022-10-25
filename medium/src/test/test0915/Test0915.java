package test.test0915;

/**
 * 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 * left中的每个元素都小于或等于right中的每个元素。
 * left 和right都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回left的长度。
 * 用例可以保证存在这样的划分方法。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0915
 * @create 2022-10-24-9:20
 */
public class Test0915 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0], index = 0, curMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                index = i;
                leftMax = curMax;
            }
        }
        return index + 1;
    }
}