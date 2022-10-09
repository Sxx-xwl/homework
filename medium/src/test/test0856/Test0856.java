package test.test0856;

import java.util.Stack;

/**
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0856
 * @create 2022-10-09-13:06
 */
public class Test0856 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int scoreOfParentheses(String s) {
        //res存储结果  mul存储当前倍数  cur存储当前值
        int res = 0, mul = 1, cur = 0;
        //循环遍历
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //如果是左括号 当前值存入结果并清零 当前倍数*2
                res += cur;
                cur = 0;
                mul *= 2;
            } else{
                //如果是右括号 当前倍数÷2 修改当前值
                mul /= 2;
                cur = Math.max(mul, cur);
            }
        }
        //将最后一次当前值存入结果并返回
        return res + cur;
    }
}