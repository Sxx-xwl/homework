package offer.offer0064;

/**
 * 求 1+2+...+n ，
 * 要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 *
 * @author sxx_27
 * @create 2022-05-30 14:04
 */
public class Offer0064 {
    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(6));
        System.out.println(new Solution().sumNums1(6));
        System.out.println(new Solution().sumNums2(6));
    }
}

class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean b = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
    public int sumNums2(int n) {
        if (n == 1){
            return 1;
        }
        n += sumNums(n-1);
        return n;
    }

    public int sumNums1(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}