package offer0056_2;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字
 *
 * @author sxx_27
 * @create 2022-05-27 14:39
 */
public class Offer0056_2 {
    public static void main(String[] args) {
        new Solution().singleNumber(new int[]{1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7});
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += arr[31 - i] % 3;
        }
        return res;
    }
}