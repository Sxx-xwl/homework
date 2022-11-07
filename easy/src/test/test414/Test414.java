package test.test414;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * https://leetcode.cn/problems/third-maximum-number/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test414
 * @create 2022-11-07-13:06
 */
public class Test414 {
    public static void main(String[] args) {
        System.out.println(new Solution().thirdMax(new int[]{6, 1, 2, 3, 4, 5}));
        System.out.println(new Solution().thirdMax(new int[]{6, 1, 1}));
        System.out.println(new Solution().thirdMax(new int[]{6, 1, 1, 1, 6, 6, 6, 1}));
        System.out.println(new Solution().thirdMax(new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        long temp = Long.MIN_VALUE;
        long a = temp, b = temp, c = temp;
        for (int cur : nums) {
            if (cur > a) {
                c = b;
                b = a;
                a = cur;
            } else if (cur > b && cur < a) {
                c = b;
                b = cur;
            } else if (cur > c && cur < b) {
                c = cur;
            }
        }
        return c == temp ? (int) a : (int) c;
    }
}