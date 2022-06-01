package offer.offer0048;

import java.util.HashSet;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，
 * 计算该最长子字符串的长度。
 *
 * @author sxx_27
 * @create 2022-05-25 13:32
 */
public class Offer0048 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcab"));
    }

}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }

        return res;
    }

    public int lengthOfLongestSubstring0(String s) {
        Set<Character> set = new HashSet<>();

        int len = s.length();
        int maxCount = 0;
        int rindex = 0;
        for (int lindex = 0; lindex < len; lindex++) {
            if (lindex != 0) {
                set.remove(s.charAt(lindex - 1));
            }
            while (rindex < len && !set.contains(s.charAt(rindex))) {
                set.add(s.charAt(rindex++));
            }
            maxCount = Math.max(maxCount, rindex - lindex);
            if (rindex >= len){
                return maxCount;
            }
        }
        return maxCount;
    }
}

