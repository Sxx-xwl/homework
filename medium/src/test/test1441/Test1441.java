package test.test1441;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组 target 和一个整数 n。每次迭代，
 * 需要从 list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * 请使用下述操作来构建目标数组 target ：
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * "Pop"：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1441
 * @create 2022-10-15-10:36
 */
public class Test1441 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < target.length; i++) {
            while (index < list.size()) {
                if (target[i] < list.get(index)) {
                    break;
                }
                res.add("Push");
                if (target[i] > list.get(index)) {
                    res.add("Pop");
                }
                index++;
            }
        }
        return res;
    }
}