package test.test0816;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，
 * 然后我们移除所有逗号，小数点和空格，得到一个字符串S。
 * 返回所有可能的原始字符串到一个列表中。
 * 原始的坐标表示法不会存在多余的零，
 * 所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
 * 此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * 最后返回的列表可以是任意顺序的。
 * 而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * https://leetcode.cn/problems/ambiguous-coordinates/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0816
 * @create 2022-11-07-10:02
 */
public class Test0816 {
    public static void main(String[] args) {
        System.out.println(new Solution().ambiguousCoordinates("(123)"));
    }
}

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            for (String l : search(s.substring(0, i))) {
                for (String r : search(s.substring(i))) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    /**
     * 将num用逗号分割
     */
    private List<String> search(String num) {
        List<String> list = new ArrayList();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i); // 分割【整数】部分
            right = num.substring(i++); // 分割【小数】部分；此处++是执行完此条语句之后才执行的
            if ((!left.equals("0") && left.charAt(0) == '0') || // 对于逗号左侧【整数】，不允许以0开头，除非这个整数就是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 对于逗号右侧【小数】，不允许以0作为结尾
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }
}