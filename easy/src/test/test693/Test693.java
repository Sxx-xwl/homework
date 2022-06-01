package test.test693;

/**给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：
 * 换句话说，就是二进制表示中相邻两位的数字永不相同。
 * @author sxx_27
 * @create 2022-03-28 9:00
 */
public class Test693 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        boolean flag = solution.hasAlternatingBits(2);
        System.out.println(flag);

    }

}


class Solution {
    public boolean hasAlternatingBits(int n) {

        int temp = n ^ (n>>1);
        return (temp & (temp + 1)) == 0;
    }
    public boolean hasAlternatingBits0(int n) {

        if (n == 1) {
            return true;
        }
        boolean flag = true;
        int temp = n % 2;
        while (n / 2 > 0)
        {
            n /= 2;
            if (temp == n % 2)
            {
                return false;
            }
            temp = n % 2;
        }
        return flag;
    }
}