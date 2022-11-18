package test.test455;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * https://leetcode.cn/problems/assign-cookies/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test455
 * @create 2022-11-18-13:48
 */
public class Test455 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0, temp = 0, len1 = g.length, len2 = s.length;
        while (index < len1 && len2 > temp) {
            if (g[index] <= s[temp]) {
                index++;
            }
            temp++;
        }
        return index;
    }
}