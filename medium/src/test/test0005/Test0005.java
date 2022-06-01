package test.test0005;

/**给你一个字符串 s，找到 s 中最长的回文子串。
 * @author sxx_27
 * @create 2022-03-07 21:37
 */
public class Test0005 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.longestPalindrome("aacabdkacaa");
        System.out.println(s);
    }

}

class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] flag = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            flag[i][i] = true;
        }

        char[] chars = s.toCharArray();
        int maxL = 0;
        int j;
        int begin = 0;

        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {

                j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    flag[i][j] = false;
                } else {
                    if (L == 2) {
                        flag[i][j] = true;
                        if (L > maxL) {
                            maxL = L;
                            begin = i;
                        }
                    } else {
                        flag[i][j] = flag[i + 1][j - 1];
                        if (L > maxL&&flag[i][j]) {
                            maxL = L;
                            begin = i;
                        }
                    }
                }

            }
        }
        String out = "";
        if (maxL == 0)
        {
            return String.valueOf(chars[0]);
        }
        for (int i = 0; i < maxL; i++) {
            out += chars[begin + i];
        }

        return out;
    }
}