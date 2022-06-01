package offer.offer0058_1;

/**输入一个英文句子，翻转句子中单词的顺序，
 * 但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @author sxx_27
 * @create 2022-05-09 13:45
 */
public class Offer0058_1 {

    public static void main(String[] args) {
        String str = "  the  sky is blue";
//        String str = "";
        String s = new Solution().reverseWords(str);
        System.out.println(s);
    }
}

class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i] != "") {
                sb.append(s1[i] + " ");
            }
        }
        return new String(sb).trim();
    }
}