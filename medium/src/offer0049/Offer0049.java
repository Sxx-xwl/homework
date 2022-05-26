package offer0049;

import java.util.HashSet;
import java.util.Set;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 *
 * @author sxx_27
 * @create 2022-05-26 13:33
 */
public class Offer0049 {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}

class Solution {

    public int nthUglyNumber0(int n) {
        int[] arr = new int[n];
        arr[0] = 1;//5
        int a = 0, b = 0, c = 0;
        int a2 = arr[a] * 2;
        int b3 = arr[b] * 3;
        int c5 = arr[c] * 5;
        for (int i = 0; i < n - 1; i++) {

            while (a2 <= arr[i] && a < n) {
                a2 = arr[++a] * 2;
            }
            while (b3 <= arr[i] && b < n) {
                b3 = arr[++b] * 3;
            }
            while (c5 <= arr[i] && c < n) {
                c5 = arr[++c] * 5;
            }
            arr[i + 1] = Math.min(a2, b3);
            arr[i + 1] = Math.min(arr[i + 1], c5);
        }
        return arr[n -1];
    }
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
