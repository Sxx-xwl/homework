package test.test415;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * https://leetcode.cn/problems/add-strings/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test415
 * @create 2022-11-16-11:29
 */
public class Test415 {
    public static void main(String[] args) {
        String num1 = "9252";
        String num2 = "863";
        System.out.println(new Solution().addStrings(num1, num2));
    }
}

class Solution {
    private StringBuilder res = new StringBuilder();

    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length(), i = len1 - 1, j = len2 - 1, sum = 0;
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            res.append(sum);
            sum /= 10;
        }
        return res.reverse().toString();
    }

}