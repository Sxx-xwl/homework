package offer0065;

/**写一个函数，求两个整数之和，
 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @author sxx_27
 * @create 2022-05-10 13:14
 */
public class Offer0065 {
    public static void main(String[] args) {

        System.out.println(new Solution().add(5, 7));
    }
}
class Solution {
    public int add(int a, int b) {
        while (b!=0){
            int c = a&b;
            a^=b;
            b = c<<1;
        }
        return a;
    }
}