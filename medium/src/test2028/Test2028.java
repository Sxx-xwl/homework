package test2028;

import java.util.Arrays;

/**现有一份 n + m次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 给你一个长度为 m 的整数数组 rolls ，其中rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 k个数字的 平均值 为这些数字求和后再除以k 。
 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被n + m整除
 * @author sxx_27
 * @create 2022-03-27 11:22
 */
public class Test2028 {

    public static void main(String[] args) {

        Solution s = new Solution();
//        int []nums = {1 ,2 ,4 ,3};//
        int []nums = {1 ,5 ,6 ,2};
//        int []nums = {1};
//        int []nums = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
//        int []nums = {3 ,2 ,4 ,3};
        int[] ints = s.missingRolls(nums, 4, 4);
        System.out.println(Arrays.toString(ints));

    }

}



class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int[] arr = new int[n];

        int sum = 0, a, b;
        int len = rolls.length;
        for (int i = 0; i < len; i++) {
            sum += rolls[i];
        }
        if (sum > mean * (n + len) || (len + n) * mean - sum > n * 6) {
            return new int[]{};
        }
        int maxCount = (len + n) * mean;
        maxCount -= sum;
        a = maxCount / n;
        if (a == 0) {
            return new int[]{};
        }
        b = maxCount % n;
        Arrays.fill(arr, a);
        for (int i = 0; i < b; i++) {
            arr[i] += 1;
        }
        return arr;
    }
}