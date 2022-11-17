package test.test0792;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定字符串 s 和字符串数组 words,
 * 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，
 * 可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列
 * https://leetcode.cn/problems/number-of-matching-subsequences/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0792
 * @create 2022-11-17-10:42
 */
public class Test0792 {
    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(new Solution().numMatchingSubseq(s, words));
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] queues = new Queue[26];
        for (int i = 0; i < 26; i++) {
            queues[i] = new LinkedList<>();
        }
        for (int i = 0; i < words.length; i++) {
            queues[words[i].charAt(0) - 'a'].add(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int size = queues[index].size();
            while (size != 0) {
                int[] poll = queues[index].poll();
                if (poll[1] == words[poll[0]].length() - 1) {
                    res++;
                } else {
                    poll[1]++;
                    queues[words[poll[0]].charAt(poll[1]) - 'a'].add(poll);
                }
                size--;
            }
        }
        return res;
    }

//    private int binarySearch(List<Integer> list, int target) {
//        int l = 0, r = list.size() - 1;
//        int mid;
//        while (l < r) {
//            mid = l + (r - l) / 2;
//            if (list.get(mid) <= target) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }
//        return list.get(l);
//    }
}