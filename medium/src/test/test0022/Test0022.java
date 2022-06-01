package test.test0022;

import java.util.ArrayList;
import java.util.List;

/**数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author sxx_27
 * @create 2022-03-12 20:28
 */
public class Test0022 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        strings.forEach(System.out::println);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        backtrack(list, new StringBuffer(), 0, 0, n);

        return list;
    }
    public void backtrack(List<String> list, StringBuffer sb , int begin , int end , int max)
    {
        if (sb.length() == 2*max)
        {
            list.add(sb.toString());
            return;
        }

        if (begin < max)
        {
            sb.append('(');
            backtrack(list, sb, begin + 1, end ,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (end < begin)
        {
            sb.append(')');
            backtrack(list, sb, begin, end+1, max);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
