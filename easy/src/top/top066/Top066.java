package top.top066;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author sxx_27
 * @create 2022-06-05 20:47
 */
public class Top066 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 9, 9})));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int nums = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                nums++;
            } else {
                break;
            }
        }
        if (nums==0){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }else if (nums < digits.length){
            for (int i = digits.length - 1 - nums; i < digits.length; i++) {
                if (i == digits.length - 1 - nums){
                    digits[i] =digits[i] + 1;
                }else {
                    digits[i] = 0;
                }
            }
            return digits;
        }
        int[] re = new int[digits.length + 1];
        re[0] = 1;
        return re;
    }
}