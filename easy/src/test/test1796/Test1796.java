package test.test1796;

/**
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，
 * 如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1796
 * @create 2022-12-03-11:26
 */
public class Test1796 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int secondHighest(String s) {
        int max = -1, res = -1;
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                if (c - '0' > max) {
                    if (max > res) {
                        res = max;
                    }
                    max = c - '0';
                } else {
                    if (c - '0' > res && c - '0' < max) {
                        res = c - '0';
                    }
                }
            }
        }
        return res;
    }
}