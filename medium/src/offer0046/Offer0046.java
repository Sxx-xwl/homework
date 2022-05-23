package offer0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。
 * 请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法
 *
 * @author sxx_27
 * @create 2022-05-23 11:35
 */
public class Offer0046 {
    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12268));
    }
}

class Solution {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int count = 0;
        int temp1 = num;
        while (temp1 != 0) {
            count++;
            temp1 /= 10;
        }
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[count - i - 1] = num % 10;
            num /= 10;
        }
        int pre0 = 1;
        int pre1 = 1;
        for (int i = 1; i < arr.length; i++) {
            int temp = pre1;
            int t = arr[i - 1] * 10 + arr[i];
            pre1 = t >= 10 && t <= 25 ? pre1 + pre0 : pre1;
            pre0 = temp;
        }
        return pre1;
    }
}