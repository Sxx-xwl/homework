package test217;

import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @author sxx_27
 * @create 2022-04-01 16:52
 */
public class Test217 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int arr[] = {1,1,1,3,3,4,3,2,4,2};
        boolean b = solution.containsDuplicate(arr);
        System.out.println(b);

    }

}
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return set.size()!=nums.length;
    }
    public boolean containsDuplicate0(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length -1)
        {
            if (nums[i] == nums[i+1])
            {
                return true;
            }
        }
        return false;
    }
}