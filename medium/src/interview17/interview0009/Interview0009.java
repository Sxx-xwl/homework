package interview17.interview0009;

/**
 * 有些数的素因子只有 3，5，7，
 * 请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，
 * 而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview17.interview0009
 * @create 2022-09-28-10:04
 */
public class Interview0009 {
    public static void main(String[] args) {
        System.out.println(new Solution().getKthMagicNumber(7));
    }
}

class Solution {
    public int getKthMagicNumber(int k) {
        int[] arr = new int[k];
        int point1 = 0, point2 = 0, point3 = 0;
        arr[0] = 1;
        for (int i = 1; i < k; i++) {
            int cur = Math.min(arr[point1] * 3, Math.min(arr[point2] * 5, arr[point3] * 7));
            arr[i] = cur;
            if (cur % 3 == 0) {
                point1++;
            }
            if (cur % 5 == 0) {
                point2++;
            }
            if (cur % 7 == 0) {
                point3++;
            }
        }
        return arr[k - 1];
    }
}