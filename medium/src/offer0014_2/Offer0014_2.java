package offer0014_2;

/**
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author sxx_27
 * @create 2022-05-14 14:00
 */
public class Offer0014_2 {

    public static void main(String[] args) {

        System.out.println(new Solution().cuttingRope(120));
        System.out.println(new Solution().cuttingRope0(120));
    }
}

class Solution {
    public int cuttingRope0(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int len = (n % 3 == 0 ? n / 3 : n / 3 + 1);
        int num = n % (2 * len);
        int index = 0;
        long res = 1;
        while (index++ < len) {
            res *= (2 + (num-- > 0 ? 1 : 0));
            res = res % 1000000007;
        }
        return (int)res;
    }
}