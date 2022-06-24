package top.top008;

/**请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * @Classname Top008
 * @Version 1.0.0
 * @Date 2022/6/24 10:21
 * @Created by sxx_xwl
 */
public class Top008 {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("9223372036854775808"));
    }
}

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long res = 0;
        char[] chars = s.toCharArray();
        boolean isNum = false;
        int index = 0, isChar = 0;
        while (index<chars.length) {
            char a = chars[index++];
            if (a == '+' || a == '-') {
                if (isChar != 0||isNum) {
                    break;
                }
                isChar = a == '+' ? 1 : -1;
            } else if (a <= '9' && a >= '0') {
                res = res * 10 + (a - '0');
                isNum = true;
                if (res + Integer.MIN_VALUE>0){
                    break;
                }
            } else {
                break;
            }
        }
        res = isChar == -1 ? -res : res;
        if (res < 0 && res - (Integer.MIN_VALUE) < 0) {
            return Integer.MIN_VALUE;
        } else if (res > 0 && res - Integer.MAX_VALUE > 0) {
            return Integer.MAX_VALUE;
        } else {
            return (int) res;
        }
    }
}