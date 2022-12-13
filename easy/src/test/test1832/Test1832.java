package test.test1832;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1832
 * @create 2022-12-13-19:11
 */
public class Test1832 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {
        char index = 'a';
        while (index <= 'z') {
            if (sentence.contains((index) + "")) {
                index++;
            } else {
                return false;
            }
        }
        return true;
    }
}