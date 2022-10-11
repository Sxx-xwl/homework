package test.test1790;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。
 * 一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），
 * 并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1790
 * @create 2022-10-11-10:43
 */
public class Test1790 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] temp = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            temp[s1.charAt(i)-'a']++;
            temp[s2.charAt(i)-'a']--;
        }
        if (count>=3){
            return false;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}