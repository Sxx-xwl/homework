package top.top191;

/**编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * @author sxx_xwl
 * @create 2022-06-17-13:03
 */
public class Top191 {
    public static void main(String[] args) {

    }
}
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
            n&=n-1;
            res++;
        }
        return res;
    }
}