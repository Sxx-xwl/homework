package top.top013;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做II，
 * 即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * @author sxx_27
 * @create 2022-06-01 14:52
 */
public class Top013 {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += search(s.charAt(i), i < s.length() - 1 ? s.charAt(i + 1) : ' ');
        }
        return res;
    }

    private int search(char c, char next) {
        switch (c) {
            case 'I':
                if (next == 'V')
                    return -1;
                if (next == 'X')
                    return -1;
                return 1;
            case 'V':
                return 5;
            case 'X':
                if (next == 'L')
                    return -10;
                if (next == 'C')
                    return -10;
                return 10;
            case 'L':
                return 50;
            case 'C':
                if (next == 'D')
                    return -100;
                if (next == 'M')
                    return -100;
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}

class Solution1 {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {

        int res = 0;
        char curValue;
        for (int i = 0; i < s.length(); i++) {
            curValue = s.charAt(i);
            if (i < s.length() - 1 && symbolValues.get(curValue) < symbolValues.get(s.charAt(i + 1))) {
                res -= symbolValues.get(curValue);
            } else {
                res += symbolValues.get(curValue);
            }
        }
        return res;
    }

}