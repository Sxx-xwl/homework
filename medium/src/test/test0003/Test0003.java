package test.test0003;

import java.util.HashMap;
import java.util.Map;

/**给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author sxx_27
 * @create 2022-03-07 20:59
 */
public class Test0003 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring1("abcabcbb");
        System.out.println(i);

    }

}
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1)
        {
            return 1;
        } else if (s.length()==0||s==null) {
            return 0;
        }
        int begin = 0;
        int flag = 0;
        int count;
        int maxCount = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            flag = i;
            if (map.containsKey(s.substring(i, i+1)))
            {
                count = flag - begin;
                if (maxCount < count)
                {
                    maxCount = count;
                }
                i = map.get(s.substring(i, i + 1))+1;
                map.clear();
                begin = i;
            }
            map.put(s.substring(i,i+1),i);
        }
        maxCount = maxCount > flag - begin + 1 ? maxCount : flag - begin +1;
        return maxCount;
    }

    public int lengthOfLongestSubstring1(String s) {

        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}