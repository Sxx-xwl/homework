package offer.offer0050;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author sxx_27
 * @create 2022-05-04 16:42
 */
public class Offer0050 {

    public static void main(String[] args) {

        System.out.println(new Solution().firstUniqChar("aaccdaeff"));

    }
}

class Solution {
    public char firstUniqChar(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a'] = res[s.charAt(i) - 'a'] == 0 ? 1 : -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}