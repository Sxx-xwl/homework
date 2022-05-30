package offer0066;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 *
 * @author sxx_27
 * @create 2022-05-30 14:34
 */
public class Offer0066 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArr(new int[]{1, 2, 3, 0, 5})));
    }
}

class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];

        int temp = 1;
        b[0] = 1;

        for (int i = 1; i < a.length; i++) {
            b[i] = a[i - 1] * b[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}