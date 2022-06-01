package test.test001;

import java.util.*;

/**给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * @author sxx_27
 * @create 2022-04-02 14:45
 */
public class Test001 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {2,7,11,15};
        int[] ints = s.twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));

    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int arr[] = new int[2];
        Map<Integer , Integer> map = new HashMap<>();
        map.put(nums[0] , 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
            {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            }
            else
            {
                map.put(nums[i],i );
            }
        }
        return arr;
    }
}