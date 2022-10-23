package test.test1768;

/**
 * 给你两个字符串 word1 和 word2 。
 * 请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1768
 * @create 2022-10-23-16:14
 */
public class Test1768 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();
        int index1 = 0, index2 = 0;
        while (len1 > index1 && len2 > index2) {
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }
        if (len1 > index1) {
            sb.append(word1.substring(index1));
        }
        if (len2 > index2) {
            sb.append(word2.substring(index2));
        }
        return sb.toString();
    }
}