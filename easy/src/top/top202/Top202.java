package top.top202;

import sun.rmi.runtime.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * @author sxx_xwl
 * @create 2022-06-17-13:10
 */
public class Top202 {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(3));
    }
}

class Solution {
    public boolean isHappy(int n) {
        long sum = n;
        Set<Long> set = new HashSet<>();
        while (true) {
            long res = sum;
            sum = 0;
            while (res != 0) {
                sum += (res % 10) * (res % 10);
                res /= 10;
            }
            if (sum == 1) {
                return true;
            } else if (!set.add(sum)) {
                return false;
            }
        }
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = next(slow);
            fast = next(next(fast));
            if (fast == 1) {
                return true;
            } else if (fast==slow) {
                return false;
            }
        }
    }

    private int next(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}