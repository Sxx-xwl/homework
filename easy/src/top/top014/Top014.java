package top.top014;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author sxx_27
 * @create 2022-06-01 15:33
 */
public class Top014 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"baab", "bacb", "b", "cbc"}));
        System.out.println(new Solution().longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Solution().longestCommonPrefix1(new String[]{"baab", "bacb", "b", "cbc"}));
    }
}

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = search(strs[i], prefix);
            if (prefix == null || prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String search(String strs, String prefix) {
        int num = 0;
        int index = 0;
        while (num < strs.length() && num < prefix.length()) {
            if (strs.charAt(num) == prefix.charAt(num)) {
                index++;
            } else {
                break;
            }
            num++;
        }
        return strs.substring(0, index);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (String s: strs){
            while (!s.startsWith(prefix)){
                if (prefix==null||prefix.length()==0){
                    return "";
                }else {
                    prefix = prefix.substring(0,prefix.length()-1);
                }
            }
        }
        return prefix;
    }

}