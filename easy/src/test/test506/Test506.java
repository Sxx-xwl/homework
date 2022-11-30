package test.test506;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，
 * 名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * https://leetcode.cn/problems/relative-ranks/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test506
 * @create 2022-11-30-11:49
 */
public class Test506 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = score.length;
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            int cur = map.get(score[n - i - 1]);
            switch (i) {
                case 0:
                    res[cur] = "Gold Medal";
                    break;
                case 1:
                    res[cur] = "Silver Medal";
                    break;
                case 2:
                    res[cur] = "Bronze Medal";
                    break;
                default:
                    res[cur] = i + "";
            }
        }
        return res;
    }
}