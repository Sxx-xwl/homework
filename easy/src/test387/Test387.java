package test387;

import java.util.HashMap;
import java.util.Map;

/**给定一个字符串 s ，找到 它的第一个不重复的字符，
 * 并返回它的索引 。如果不存在，则返回 -1 。
 * @author sxx_27
 * @create 2022-04-07 21:42
 */
public class Test387 {

    public static void main(String[] args) {
        String s = "leetcode";
        int i = new Solution().firstUniqChar(s);
        System.out.println(i);
    }
}

class Solution {
    public int firstUniqChar0(String s) {

        if (s.length() == 1)
        {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char subs = s.charAt(i);
            if (map.containsKey(subs)) {
                map.put(subs, map.get(subs) + 1);
            } else {
                map.put(subs, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char subs = s.charAt(i);
            if (map.get(subs) == 1) {
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar(String s) {

        if (s.length() == 1)
        {
            return 0;
        }
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int subs = s.charAt(i) - 'a';
            arr[subs]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int subs = s.charAt(i) - 'a';
            if (arr[subs] == 1) {
                return i;
            }
        }
        return -1;
    }
}
