package test.test169;

import java.util.Arrays;

/**给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author sxx_27
 * @create 2022-02-24 17:40
 */
public class Test169 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {2,1,2};
        int i = solution.majorityElement(nums);
        System.out.println(i);

    }

}
class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}