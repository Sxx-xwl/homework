package offer.offer0010_2;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author sxx_27
 * @create 2022-04-26 20:21
 */
public class Offer0010_2 {

    public static void main(String[] args) {

        System.out.println(new Solution().numWays(5));
    }
}

/*
0 - 1   1  -  1    2 - 2   3 - ( 1 + 2 )   4 - ( 3 + 2 )

 */
class Solution {
    public int numWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre2;
            pre2 = (pre2 + pre1)% 1000000007;
            pre1 = temp;
        }
        return pre2;
    }
}