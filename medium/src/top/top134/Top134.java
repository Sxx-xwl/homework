package top.top134;

/**
 * 在一条环路上有 n个加油站，
 * 其中第 i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，
 * 从第 i 个加油站开往第i+1个加油站需要消耗汽油cost[i]升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas和cost ，
 * 如果你可以绕环路行驶一周，
 * 则返回出发时加油站的编号，否则返回-1 。
 * 如果存在解，则保证它是唯一的。
 *
 * @Classname Top134
 * @Version 1.0.0
 * @Date 2022/7/12 19:34
 * @Created by sxx_xwl
 */
public class Top134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] temp = new boolean[gas.length];
        int newGas = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0 && !temp[i]) {
                for (int j = i; j < gas.length + i; j++) {
                    temp[j % gas.length] = true;
                    newGas += gas[j % gas.length] - cost[j % gas.length];
                    if (newGas < 0) {
                        newGas = 0;
                        break;
                    }
                    if (j == gas.length + i - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}