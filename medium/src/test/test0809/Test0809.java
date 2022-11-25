package test.test0809;

import java.util.Set;

/**
 * 有时候人们会用重复写一些字母来表示额外的感受，
 * 比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，
 * 我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），
 * 然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，
 * 但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，
 * 我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。
 * 如果 S = "helllllooo"，那么查询词 "hello" 是可扩张的，
 * 因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = S。
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * https://leetcode.cn/problems/expressive-words/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0809
 * @create 2022-11-25-10:58
 */
public class Test0809 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
            char aa, bb;
            while (b1 < word.length() && a1 < s.length()) {
                aa = s.charAt(a2);
                bb = word.charAt(b2);
                if (aa != bb) {
                    break;
                }
                while (a2 < s.length() && aa == s.charAt(a2)) {
                    a2++;
                }
                while (b2 < word.length() && bb == word.charAt(b2)) {
                    b2++;
                }
                int len1 = a2 - a1, len2 = b2 - b1;
                if (len1 < len2) {
                    break;
                }
                if (len1 == 2 && len2 == 1) {
                    break;
                }
                a1 = a2;
                b1 = b2;
            }
            if (b1 == word.length() && a1 == s.length()) {
                res++;
            }
        }
        return res;
    }
}