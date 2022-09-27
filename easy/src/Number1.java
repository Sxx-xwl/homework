/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className PACKAGE_NAME
 * @create 2022-09-27-20:45
 */
public class Number1 {
    public static void main(String[] args) {
        System.out.println(new Solution().ReverseSentence("nowcoder. a am I"));
        System.out.println(new Solution().ReverseSentence(" nowcoder. a am I "));
        System.out.println(new Solution().ReverseSentence("nowcoder."));
        System.out.println(new Solution().ReverseSentence("n "));
        System.out.println(new Solution().ReverseSentence(" n"));
        System.out.println(new Solution().ReverseSentence(""));
        System.out.println(new Solution().ReverseSentence("          nowcoder       "));
    }
}

class Solution {
    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length == 0){
            return "";
        }
        int index = length - 1;
        int l = length - 1, r = length - 1;
        while (index >= 0) {
            if (str.charAt(index) != ' ') {
                r = index--;
                l = r;
                while (index >= 0 && str.charAt(index) != ' ') {
                    l--;
                    index--;
                }
                sb.append(str.substring(l, r + 1));
                sb.append(" ");
            }
            index--;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}