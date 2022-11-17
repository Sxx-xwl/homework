package test.test434;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * https://leetcode.cn/problems/number-of-segments-in-a-string/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test434
 * @create 2022-11-17-15:19
 */
public class Test434 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countSegments(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int res = 0;
        String[] ss = s.split(" ");
        for(String temp : ss){
            if (!temp.isEmpty()&&!temp.equals(" ")){
                res++;
            }
        }
        return res;
    }
}