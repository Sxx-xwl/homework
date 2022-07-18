package top.top166;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，
 * 分别表示分数的分子numerator 和分母 denominator，
 * 以 字符串形式返回小数 。
 * 如果小数部分为循环小数，
 * 则将循环的部分括在括号内。
 * 如果存在多个答案，
 * 只需返回 任意一个 。
 * 对于所有给定的输入，
 * 保证 答案字符串的长度小于 104 。
 *
 * @Classname Top166
 * @Version 1.0.0
 * @Date 2022/7/18 13:52
 * @Created by sxx_xwl
 */
public class Top166 {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(4, 333));
    }
}

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if (a > 0 && b < 0 || a < 0 && b > 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) {
            return sb.toString();
        }
        return sb.insert(map.get(a), "(").append(')').toString();
    }
}