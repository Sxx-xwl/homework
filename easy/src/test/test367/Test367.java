package test.test367;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test367
 * @create 2022-11-05-16:35
 */
public class Test367 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(808201));
        System.out.println(new Solution().isPerfectSquare(808201));
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (mid > num / mid) r = mid;
            else {
                if (num/mid==mid && num % mid == 0) return true;
                l = mid + 1;
            }
        }
        return num == 1 || false;
    }
}