package test.test459;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * https://leetcode.cn/problems/repeated-substring-pattern/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test459
 * @create 2022-11-18-13:55
 */
public class Test459 {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("ababba"));
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }
}