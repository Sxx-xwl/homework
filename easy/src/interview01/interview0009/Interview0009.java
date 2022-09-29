package interview01.interview0009;

/**
 * 字符串轮转。给定两个字符串s1和s2，
 * 请编写代码检查s2是否为s1旋转而成
 * （比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview01.interview0009
 * @create 2022-09-29-14:57
 */
public class Interview0009 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (s1==null||len1==0) return true;
        int index = 0;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(index) == s2.charAt(i)) {
                while (index < len1) {
                    if (s1.charAt(index) != s2.charAt((i + index) % len2)) {
                        break;
                    } else {
                        index++;
                    }
                }
                if (index == len1) {
                    return true;
                } else {
                    index = 0;
                }
            }
        }
        return false;
    }
}