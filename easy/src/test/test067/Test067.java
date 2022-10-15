package test.test067;

/**
 * 给你两个二进制字符串 a 和 b ，
 * 以二进制字符串的形式返回它们的和。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test067
 * @create 2022-10-15-22:38
 */
public class Test067 {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        int lmin = Math.min(alen, blen);
        int lmax = Math.max(alen, blen);
        int index = 0, flag = 0;
        StringBuilder sb = new StringBuilder();
        while (index < lmin) {
            int numa = a.charAt(alen - index - 1) - '0';
            int numb = b.charAt(blen - index - 1) - '0';
            sb.append((numa + numb + flag) % 2);
            flag = (numa + numb + flag) / 2;
            index++;
        }
        while (index < lmax && index < alen) {
            int numa = a.charAt(alen - index - 1) - '0';
            sb.append((numa + flag) % 2);
            flag = (numa + flag) / 2;
            index++;
        }
        while (index < lmax && index < blen) {
            int numb = b.charAt(blen - index - 1) - '0';
            sb.append((numb + flag) % 2);
            flag = (numb + flag) / 2;
            index++;
        }
        if (flag == 1) sb.append(1);
        return sb.reverse().toString();
    }
}