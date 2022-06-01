package offer.offer0003;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author sxx_27
 * @create 2022-04-20 21:39
 */
public class Offer0003 {

    public static void main(String[] args) {

        int arr[] = {3, 4, 2, 0, 0, 1};
        int repeatNumber = new Solution().findRepeatNumber(arr);
        System.out.println(repeatNumber);
        System.out.println(3 ^ 4);
    }

}

class Solution {
    public int findRepeatNumber(int[] nums) {

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return res;
    }

    public int findRepeatNumber2(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if ((res ^ nums[j]) == 0) {
                    return nums[j];
                }
            }
        }
        return res;
    }

    public int findRepeatNumber1(int[] nums) {

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                return num;
            }
        }
        return res;
    }
}
