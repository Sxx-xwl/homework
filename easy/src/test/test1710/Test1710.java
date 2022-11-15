package test.test1710;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，
 * 其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。
 * 只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * 返回卡车可以装载 单元 的 最大 总数。
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1710
 * @create 2022-11-15-10:37
 */
public class Test1710 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        int[] temp = new int[1001];
        for (int[] arr : boxTypes) {
            temp[arr[1]] += arr[0];
        }
        for (int i = temp.length - 1; i > 0 && truckSize > 0; i--) {
            if (temp[i] > 0) {
                if (truckSize > temp[i]) {
                    res += i * temp[i];
                    truckSize -= temp[i];
                } else {
                    res += truckSize * i;
                    truckSize = 0;
                }
            }
        }
        return res;
    }
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[1] - o1[1];
//            }
//        });
//        int res = 0;
//        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
//            if (truckSize > boxTypes[i][0]) {
//                res += boxTypes[i][0] * boxTypes[i][1];
//                truckSize -= boxTypes[i][0];
//            } else {
//                res += truckSize * boxTypes[i][1];
//                truckSize = 0;
//            }
//        }
//        return res;
//    }
}