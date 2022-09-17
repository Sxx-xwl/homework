package offerTwo.offerTwo0017;

/**
 * 给定两个字符串 s 和t 。
 * 返回 s 中包含t的所有字符的最短子字符串。
 * 如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className offerTwo.offerTwo0017
 * @create 2022-09-17-21:38
 */
public class OfferTwo0017 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] ss = new int[58], tt = new int[58];
        int l = 0, r = 0, count = 0;
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i) - 'A']++;
        }
        String res = "";
        while (r < s.length()) {
            ss[s.charAt(r) - 'A']++;
            if (ss[s.charAt(r) - 'A'] <= tt[s.charAt(r) - 'A']) {
                count++;
            }
            while (l <= r && ss[s.charAt(l) - 'A'] > tt[s.charAt(l) - 'A']) {
                ss[s.charAt(l) - 'A']--;
                l++;
            }
            if (count == t.length() && (res.isEmpty() || res.length() > (r - l + 1))) {
                res = s.substring(l, r + 1);
            }
            r++;
        }
        return res;
    }
}