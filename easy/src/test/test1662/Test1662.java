package test.test1662;

/**
 * 给你两个字符串数组 word1 和 word2 。
 * 如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1662
 * @create 2022-11-01-13:36
 */
public class Test1662 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int a1 = 0, b1 = 0, index1 = 0, index2 = 0;
        while (a1 < word1.length && b1 < word2.length) {
            if (word1[a1].charAt(index1++) != word2[b1].charAt(index2++)) {
                return false;
            }
            if (index1 >= word1[a1].length()) {
                index1 = 0;
                a1++;
            }
            if (index2 >= word2[b1].length()) {
                index2 = 0;
                b1++;
            }
        }
        return a1 >= word1.length && b1 >= word2.length;
    }
}
