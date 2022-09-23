package test.test1640;
import jdk.jfr.Unsigned;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。
 * 另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
 * 但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，
 * 返回 true ；否则，返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1640
 * @create 2022-09-23-12:59
 */
public  class Test1640 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], pieces[i]);
        }

        while (map.containsKey(arr[index])) {
            int[] ints = map.get(arr[index]);
            int num = 0;
            for (num = 0; num < ints.length; num++) {
                if (arr[index] != ints[num]) {
                    break;
                } else {
                    index++;
                }
            }
            if (num != ints.length) {
                return false;
            }
            if (index==arr.length){
                return true;
            }
        }
        return false;
    }
}