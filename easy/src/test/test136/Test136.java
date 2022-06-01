package test.test136;

/**
 * @author sxx_27
 * @create 2022-01-20 20:22
 */
public class Test136 {
    

}

class Solution {
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
}
