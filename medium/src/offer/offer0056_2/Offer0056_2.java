package offer.offer0056_2;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字
 *
 * @author sxx_27
 * @create 2022-05-27 14:39
 */
public class Offer0056_2 {
    public static void main(String[] args) {
        new Solution().singleNumber(new int[]{1, 2, 3, 3, 2, 1, 1, 2, 3, 7});
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        //a为对应位的1出现2次的记录，b为对应位出现1次的记录，ab共同组成该位出现的次数
        int a = 0, b = 0;
        for (int i : nums) {
            b = ~a & (b ^ i);
            a = ~b & (a ^ i);
        }
        return b;
    }

}