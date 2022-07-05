package top.top056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [start, end] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
 * 该数组需恰好覆盖输入中的所有区间 。
 *
 * @Classname Top056
 * @Version 1.0.0
 * @Date 2022/7/5 13:19
 * @Created by sxx_xwl
 */
public class Top056 {
    public static void main(String[] args) {
        int[][] arr = {{1, 5}, {2, 3}};
        int[][] merge = new Solution().merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}

class Solution {
    List<int[]> list;

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        search(intervals, 0);
        return list.toArray(new int[list.size()][]);
    }

    private void search(int[][] intervals, int size) {
        list = new ArrayList<>();
        int end = 1;
        int l = intervals[0][0];
        int r = intervals[0][1];
        while (end < intervals.length) {
            int startl = l;
            int startr = r;
            int endl = intervals[end][0];
            int endr = intervals[end][1];
            if (startr < endl) {
                list.add(new int[]{l, r});
                l = endl;
                r = endr;
            } else {
                l = Math.min(startl, endl);
                r = Math.max(endr, startr);
            }
            end++;
        }
        list.add(new int[]{l, r});
        if (size == list.size()) {
            return;
        } else {
            search(list.toArray(new int[0][]), list.size());
        }
    }
}