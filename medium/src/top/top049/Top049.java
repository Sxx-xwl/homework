package top.top049;

import java.util.*;

/**
 * 给你一个字符串数组，请你将字母异位词组合在一起。
 * 可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，
 * 所有源单词中的字母通常恰好只用一次。
 *
 * @Classname Top049
 * @Version 1.0.0
 * @Date 2022/6/30 15:06
 * @Created by sxx_xwl
 */
public class Top049 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        for (int i = 0; i < new Solution().groupAnagrams(strs).size(); i++) {
            List<String> list = new Solution().groupAnagrams(strs).get(i);
            System.out.println(list);
        }
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        if (strs.length == 0 || strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            listList.add(list);
            return listList;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.get(s) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(s, temp);
            } else {
                map.get(s).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}