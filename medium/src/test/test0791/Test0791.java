package test.test0791;


/**
 * 给定两个字符串 order 和 s 。
 * order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。
 * 更具体地说，如果在 order 中的字符 x 出现字符 y 之前，
 * 那么在排列后的字符串中， x 也应该出现在 y 之前。
 * 返回 满足这个性质的 s 的任意排列
 * https://leetcode.cn/problems/custom-sort-string/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0791
 * @create 2022-11-14-15:36
 */
public class Test0791 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String customSortString(String order, String s) {
        char[] ss = s.toCharArray();
        char[] oo = order.toCharArray();
        int[] temp = new int[26];
        for (char c : ss) {
            temp[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : oo) {
            while (temp[c - 'a'] != 0) {
                sb.append(c);
                temp[c - 'a']--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] != 0) {
                sb.append((char) (i + 'a'));
                temp[i]--;
            }
        }
        return sb.toString();
    }
}