package top.top172;

/**
 * @Classname Top172
 * @Version 1.0.0
 * @Date 2022/7/18 14:37
 * @Created by sxx_xwl
 */
public class Top172 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n / 5 != 0) {
            res += (n / 5);
            n/=5;
        }
        return res;
    }
}