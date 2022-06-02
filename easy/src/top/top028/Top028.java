package top.top028;

/**
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * 说明：
 * 当needle是空字符串时，
 * 我们应当返回什么值呢？
 * 这是一个在面试中很好的问题。
 * 对于本题而言，
 * 当needle是空字符串时我们应当返回 0 。
 * 这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 * @author sxx_27
 * @create 2022-06-02 16:35
 */
public class Top028 {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j)!=needle.charAt(j)){
                    break;
                }
                if (j==needle.length() - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}