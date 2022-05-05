package test338;

import java.util.Arrays;

/**给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @author sxx_27
 * @create 2022-02-25 16:58
 */
public class Test338 {


    public static void main(String[] args) {

    Solution solution = new Solution();
        int[] ints = solution.countBits(3);

        System.out.println(Arrays.toString(ints));

    }

}

class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];

        arr[0] = 0;
        for (int i = 1; i < n+1; i++) {
            if (i%2==0)
            {
                arr[i] = arr[i>>1];
            }else
            {
                arr[i] = arr[i-1]+1;
            }
        }

        return arr;
    }
}