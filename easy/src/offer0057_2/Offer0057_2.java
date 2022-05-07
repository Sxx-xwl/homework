package offer0057_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 输入一个正整数 target ，
 * 输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @author sxx_27
 * @create 2022-05-07 17:33
 */
public class Offer0057_2 {
    public static void main(String[] args) {

        int[][] continuousSequence = new Solution().findContinuousSequence(9);
        System.out.println(Arrays.toString(continuousSequence));
    }
}

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        //🧠里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
        //套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
        //当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
        for (int l = 1, r = 1, sum = 0; r <= target / 2 + 1; r++) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] findContinuousSequence0(int target) {
        List<int[]> res = new ArrayList<>();
        int result = target;
        for (int i = 1; i <= target / 2; i++) {
            result -= i;
            for (int j = i + 1; ; j++) {
                result -= j;
                if (result == 0) {
                    int[] ints = new int[j - i + 1];
                    for (int k = i; k < j + 1; k++) {
                        ints[k - i] = k;
                    }
                    res.add(ints);
                    break;
                } else if (result < 0) {
                    result = target;
                    break;
                }
            }
        }
        int[][] a = new int[res.size()][];
        for (int i = 0; i < a.length; i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}