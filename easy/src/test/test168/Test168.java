package test.test168;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test168
 * @create 2022-10-19-16:28
 */
public class Test168 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            int temp = columnNumber % 26;
            sb.append((char) ('A' + temp));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}