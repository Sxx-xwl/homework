package test.test461;

/**两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。

 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * @author sxx_27
 * @create 2022-02-27 14:03
 */
public class Test461 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.hammingDistance(7, 1);
        int i1 = solution.hammingDistance1(7, 1);
        int i2 = solution.hammingDistance2(7, 1);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

    }


}
class Solution {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x^y);
    }
    public int hammingDistance1(int x, int y) {

        int count = 0;
        while (x!=0 || y!=0)
        {
            if (x%2 != y%2)
            {
                count++;
            }
            x /= 2;
            y /= 2;
        }

        return count;
    }
    public int hammingDistance2(int x, int y) {

        return Integer.bitCount(x^y);
    }
}