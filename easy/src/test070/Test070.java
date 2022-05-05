package test070;

/**
 * @author sxx_27
 * @create 2022-01-20 19:28
 */
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test070 {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.climbStairs(6));

    }
}

class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        for (int i = 3; i <= n; i++) {
            a = a + b;
            a = a^b;
            b = a^b;
            a = a^b;
        }
        return b;
    }

}
