package test.test0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，
 * 返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * https://leetcode.cn/problems/combinations/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0077
 * @create 2022-11-21-11:30
 */
public class Test0077 {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(3, 2));
    }
}

class Solution {
    private List<List<Integer>> listList;

    public List<List<Integer>> combine(int n, int k) {
        listList = new ArrayList<>();
        search(new LinkedList<>(), n, k, 1);
        return listList;
    }

    private void search(LinkedList<Integer> list, int n, int k, int index) {
        if (list.size() >= k) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.addLast(i);
            search(list, n, k, i + 1);
            list.removeLast();
        }
    }
}