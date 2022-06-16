package top.top171;

/**
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号。
 * <p>
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * @author sxx_xwl
 * @create 2022-06-16-20:55
 */
public class Top171 {
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("ZY"));
    }
}

class Solution {
    public int titleToNumber(String columnTitle) {
        int flag = 1;
        int res = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * flag;
            flag *= 26;
        }
        return res;
    }
}