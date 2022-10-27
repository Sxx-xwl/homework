package tree.test290;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.test290
 * @create 2022-10-27-13:44
 */
public class Test290 {
    public static void main(String[] args) {
        String str = "dog cat cat dog";
//        String[] s = str.split(" ");
//        for (String ss : s){
//            System.out.println(ss);
//        }
        System.out.println(new Solution().wordPattern("abba",str));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] s1 = s.split(" ");
        if (s1.length!=pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(s1[i])) return false;
                map.put(c, s1[i]);
            } else {
                if (!map.get(c).equals(s1[i])) return false;
            }
        }
        return true;
    }
}