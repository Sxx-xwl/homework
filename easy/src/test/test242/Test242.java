package test.test242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * @author sxx_27
 * @create 2022-04-07 20:34
 */
public class Test242 {

    public static void main(String[] args) {

        String s = "ana";
        String t = "tna";
        boolean anagram = new Solution().isAnagram(s, t);
        System.out.println(anagram);
    }
}

class Solution {
    public boolean isAnagram0(String s, String t) {

        if (s.length() != t.length())
        {
            return false;
        }
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char subs = s.charAt(i);
            if (map.containsKey(subs))
            {
                map.put(subs, map.get(subs) + 1);
            }else
            {
                map.put(subs, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char subt = t.charAt(i);
            if (map.containsKey(subt))
            {
                map.put(subt, map.get(subt) - 1);
                if (map.get(subt) < 0)
                {
                    return false;
                }
            }else
            {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
        {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}