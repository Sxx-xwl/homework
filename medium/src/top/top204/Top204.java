package top.top204;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top204
 * @create 2022-08-22-13:35
 */
public class Top204 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.countPrimes(10);
        System.out.println(i);
    }
}

class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int nums = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 1) {
                int index = 2 * i;
                while (index < n) {
                    arr[index] = 0;
                    index += i;
                }
            }
        }
        for (int a : arr) {
            nums += a;
        }
        return nums;
    }
}
