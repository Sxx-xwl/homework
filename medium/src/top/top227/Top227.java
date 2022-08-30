package top.top227;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在[-231, 231- 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top227
 * @create 2022-08-30-21:44
 */
public class Top227 {
    public static void main(String[] args) {
        String str = " 0-2 ";
        System.out.println(new Solution().calculate(str));
    }
}

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int num = 0;
        int num1, num2;
        boolean flag = false;
        boolean isFlag = false;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '+' || c == '-') {
                if (flag) {
                    num2 = num;
                    num1 = numStack.pop();
                    num = cal(num1, num2, stack.pop());
                    flag = false;
                }
                if (isFlag) {
                    numStack.push(-num);
                    isFlag = false;
                } else {
                    numStack.push(num);
                }
                if (c == '-') {
                    isFlag = true;
                }
                num = 0;
                stack.push('+');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == '*' || c == '/') {
                if (flag) {
                    num2 = num;
                    num1 = numStack.pop();
                    num = cal(num1, num2, stack.pop());
                }
                if (isFlag) {
                    numStack.push(-num);
                    isFlag = false;
                } else {
                    numStack.push(num);
                }
                num = 0;
                flag = true;
                stack.push(c);
            } else if (c == ')') {
                char top = stack.pop();
                while (top != '(') {
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    int cal = cal(num1, num2, top);
                    numStack.push(cal);
                    top = stack.pop();
                }
            } else {
                num = num * 10 + (c - '0');
            }
        }
        if (isFlag) {
            numStack.push(-num);
        } else {
            numStack.push(num);
        }
        char top;
        while (!stack.empty()) {
            top = stack.pop();
            num2 = numStack.pop();
            num1 = numStack.pop();
            int cal = cal(num1, num2, top);
            numStack.push(cal);
        }
        return numStack.pop();
    }

    private int cal(int num1, int num2, char slogan) {
        switch (slogan) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
}