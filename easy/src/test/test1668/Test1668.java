package test.test1668;

/**
 * 给你一个字符串 sequence ，
 * 如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * 那么单词 word 的 重复值为 k 。
 * 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1668
 * @create 2022-11-03-10:19
 */
public class Test1668 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxRepeating("ababc", "ab"));
    }
}

class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int res = 0;
        while (sequence.contains(sb.toString())) {
            res++;
            sb.append(word);
        }
        return res;
    }
}