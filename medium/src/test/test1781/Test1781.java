package test.test1781;

import java.util.*;

/**
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1781
 * @create 2022-12-12-10:25
 */
public class Test1781 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int beautySum(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length, res = 0;
        for (int i = 0; i < len; i++) {
            int[] temp = new int[26];
            temp[chars[i] - 'a']++;
            for (int j = i + 1; j < len; j++) {
                temp[chars[j] - 'a']++;
                int minV = 501, maxV = -1;
                for (int k = 0; k < 26; k++) {
                    if (temp[k] != 0) {
                        minV = Math.min(temp[k], minV);
                        maxV = Math.max(temp[k], maxV);
                    }
                }
                res += maxV - minV;
            }
        }
        return res;
    }
}