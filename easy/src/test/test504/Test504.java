package test.test504;

/**给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * @author sxx_27
 * @create 2022-03-07 23:16
 */
public class Test504 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.convertToBase7(0);
        System.out.println(s);
    }
}
class Solution {
    public String convertToBase7(int num) {

        boolean flag = true;
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            flag = false;
            num = -num;
        }
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (!flag) {
            sb.append('-');
        }
        sb = sb.reverse();
        return String.valueOf(sb);

    }
}