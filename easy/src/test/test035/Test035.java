package test.test035;

/**给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 请必须使用时间复杂度为 O(log n) 的算法。
 * @author sxx_27
 * @create 2022-03-16 21:32
 */
public class Test035 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {1,3,5,6};
        int i = s.searchInsert(arr, 2);
        System.out.println(i);

    }


}


class Solution {
    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int m;
        int temp = 0;

        while (l <= r) {
            m = (l + r) >> 1;
            if (nums[m] < target) {
                l = m + 1;
                if (m == nums.length - 1) {
                    temp = nums.length;
                }
            } else if (nums[m] > target) {
                temp = m;
                r = m - 1;
            } else {
                return m;
            }
        }
        return temp;
    }

}