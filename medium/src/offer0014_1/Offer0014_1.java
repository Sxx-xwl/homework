package offer0014_1;

/**
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 *
 * @author sxx_27
 * @create 2022-05-13 14:03
 */
public class Offer0014_1 {
    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(16));
    }
}

class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        }
        int[] res = new int[(n % 3) == 0 ? n / 3 : n / 3 + 1];
        int index = 0;
        int a = n % (res.length * 2);
        while (index < res.length) {
            res[index++] = 2 + (a-- < 1 ? 0 : 1);
        }
        int num = 1;
        for (int i = 0; i < res.length; i++) {
            num *= res[i];
        }
        return num;
    }
}