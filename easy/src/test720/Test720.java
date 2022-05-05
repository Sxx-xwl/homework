package test720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * @author sxx_27
 * @create 2022-03-17 21:23
 */
public class Test720 {

    public static void main(String[] args) {

        Solution s = new Solution();

        String[] strs = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String s1 = s.longestWord(strs);

        System.out.println(s1);
    }

}


class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words);
        String longest = "";
        Set<String> candidates = new HashSet<>();
        candidates.add("");
        for (int i = 0; i < words.length; i++) {
            if (candidates.contains(words[i].substring(0, words[i].length() - 1))) {
                candidates.add(words[i]);
                longest = words[i].length() > longest.length() ? words[i] : longest;
            }
        }
        return longest;
    }
    public String longestWord1(String[] words) {
        Arrays.sort(words, (a, b) ->  {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String longest = "";
        Set<String> candidates = new HashSet<>();
        candidates.add("");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }
}