package offer.offer0058_2;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author sxx_27
 * @create 2022-05-09 14:15
 */
public class Offer0058_2 {
    public static void main(String[] args) {

        String str = "abcdefg";
        String s = new Solution().reverseLeftWords(str, 2);
        System.out.println(s);
    }
}

class Solution {
    public String reverseLeftWords0(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return new String(sb);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0, n);
    }
}