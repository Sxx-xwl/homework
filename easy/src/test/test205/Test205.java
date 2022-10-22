package test.test205;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test205
 * @create 2022-10-22-10:32
 */
public class Test205 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s1 = new int[128];
        int[] t1 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i)]++;
            t1[t.charAt(i)]++;
            if (s1[s.charAt(i)] != t1[t.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), t.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}