package offer0044;

import java.util.Arrays;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，
 * 第5位（从下标0开始计数）是5，
 * 第13位是1，
 * 第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * @author sxx_27
 * @create 2022-05-21 14:01
 */
public class Offer0044 {

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(2));
    }
}

/* 数字范围    数量  位数    占多少位
    1-9        9      1       9
    10-99      90     2       180
    100-999    900    3       2700
    1000-9999  9000   4       36000  ...
   19  --  4    10 11 12 13 14
    例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
    数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
    定位1002中的位置 = (n - 1) %  4 = 3    s.charAt(3) = 2;
*/
class Solution {
    public int findNthDigit(int n) {
        if (n/10==0){
            return n;
        }
        long bit = 9; //占多少位
        long digit = 1; //第一个数
        int nums = 1; //位数
        while (n > bit) {
            n -= bit;
            nums++;
            digit *= 10;
            bit = nums * digit * 9;
        }
        long res = digit +  (n - 1) / nums;
        return Long.toString(res).charAt((n - 1) % nums) - '0';
    }
}