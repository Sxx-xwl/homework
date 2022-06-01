package test.test0006;

/**将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行  Z 字形排列。

 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);

 * @author sxx_27
 * @create 2022-03-01 19:51
 */
public class Test0006 {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        String paypalishiring = solution.convert("PAYPALISHIRING", 3);
//        String paypalishiring = solution.convert1("PAYPALISHIRING", 3);
        String paypalishiring = solution.convert2("PAYPALISHIRING", 3);
//        String paypalishiring = solution.convert("AB", 1);
        System.out.println(paypalishiring);

    }

}
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1)
        {
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        int x = 0;
        int y = 0;
        int count = 0;
        while (count <= s.length() - 1) {

            while (x <= numRows - 1) {
                if (count > s.length() - 1) {
                    break;
                }
                arr[x][y] = s.charAt(count++);
                x++;
            }
            if (count > s.length() - 1) {
                break;
            }
            x = x - 2;
            y++;
            while (x >= 0) {
                if (count > s.length() - 1) {
                    break;
                }
                arr[x][y] = s.charAt(count++);
                x--;
                y++;
            }
            y--;
            x = x + 2;

        }
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < numRows; i++) {

            int flag = 0;
            for (int j = 0; j < s.length(); j++) {

                if (arr[i][j] != 0) {
                    sb.append(arr[i][j]);
                    flag = 0;
                }
                flag++;
                if (flag == numRows-1){
                    break;
                }
            }
        }

        s = String.valueOf(sb);
        return s;

    }

    public String convert1(String s,int numRows){

        String[] str = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = "";
        }
        boolean flag = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {

            if (flag) {
                str[row++] += s.substring(i, i + 1);
                if (row == numRows) {
                    row -= 2;
                    flag = false;
                }
            } else {
                str[row--] += s.substring(i, i + 1);
                if (row == -1) {
                    row += 2;
                    flag = true;
                }
            }
        }
        s = "";
        for (int i = 0; i < numRows; i++) {
            s += str[i];
        }
        return s;
    }

    public String convert2(String s,int numRows){
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        String ans = "";
        int t = r * 2 - 2;
        for (int i = 0; i < r; ++i) { // 枚举矩阵的行
            for (int j = 0; j + i < n; j += t) { // 枚举每个周期的起始下标
                ans += s.substring(j+i,j+i+1); // 当前周期的第一个字符
                if (0 < i && i < r - 1 && j + t - i < n) {
                    ans +=  s.substring(j + t - i,j+t-i+1); // 当前周期的第二个字符
                }
            }
        }
        return ans;
    }
}
