package test.test2418;

import java.util.Arrays;

/**
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * https://leetcode.cn/problems/sort-the-people/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test2418
 * @create 2022-11-11-10:35
 */
public class Test2418 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = heights.length;
        int[][] temp = new int[len][2];
        for (int i = 0; i < len; i++) {
            temp[i][0] = heights[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp, (o1, o2) -> o1[0] - o2[0]);
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[len - i - 1] = names[temp[i][1]];
        }
        return res;
    }
}
