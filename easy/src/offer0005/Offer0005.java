package offer0005;

/**请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author sxx_27
 * @create 2022-04-23 21:14
 */
public class Offer0005 {

    public static void main(String[] args) {

        String str = "We are happy.";
        System.out.println(str);
        String s = new Solution().replaceSpace(str);
        System.out.println(s);

    }

}
class Solution {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i)==' '){
               sb.append("%20");
           }else {
               sb.append(s.charAt(i));
           }
        }
        return new String(sb);
    }
}