package top.top150;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，
 * 表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * @Classname Top150
 * @Version 1.0.0
 * @Date 2022/7/17 14:18
 * @Created by sxx_xwl
 */
public class Top150 {
    public static void main(String[] args) {
        String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(str));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                stack.push(Integer.parseInt(token));
            } catch (Exception e) {
                int l = stack.pop();
                int r = stack.pop();
                switch (token) {
                    case "+":
                        stack.add(r + l);
                        break;
                    case "-":
                        stack.add(r - l);
                        break;
                    case "*":
                        stack.add(r * l);
                        break;
                    default:
                        stack.add(r / l);
                        break;
                }
            }
        }
        return stack.peek();
    }
}