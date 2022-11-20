package test.test0012;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 * 12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * https://leetcode.cn/problems/integer-to-roman/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0012
 * @create 2022-11-19-11:23
 */
public class Test0012 {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(14));
    }
}

class Solution {
    private Map<Integer, Character> map;

    public String intToRoman(int num) {
        map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        int cur = 1;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num % 10;
            switch (temp) {
                case 0:
                    break;
                case 9:
                    sb.append(map.get(cur * 10));
                    sb.append(map.get(cur));
                    break;
                default:
                    int flag = temp % 5;
                    temp = temp / 5;
                    if (flag == 4) {
                        sb.append(map.get(5 * cur));
                        sb.append(map.get(cur));
                    } else {
                        while (flag > 0) {
                            sb.append(map.get(cur));
                            flag--;
                        }
                    }
                    if (temp > 0) {
                        sb.append(map.get(temp * 5 * cur));
                    }
                    break;
            }
            cur *= 10;
            num /= 10;
        }
        return sb.reverse().toString();
    }
}