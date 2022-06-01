package offer.offer0017;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author sxx_27
 * @create 2022-04-27 21:10
 */
public class Offer0017 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().printNumbers(3)));

    }
}

class Solution {
    public int[] printNumbers(int n) {
        int count = 1;
//        while ((n - 1) > 0) {
//            count = count * 10 + 1;
//            n--;
//        }
//        count *= 9;
        while (n > 0) {
            count *= 10;
            n--;
        }
        count -= 1;
        int[] res = new int[count];
        for (int i = 1; i <= count; i++) {
            res[i - 1] = i;
        }

        return res;
    }
}