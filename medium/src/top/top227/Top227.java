package top.top227;

import java.util.ArrayDeque;
import java.util.Deque;

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
        String str = " 3/2+3* 5-2* 2+0-2 ";
        System.out.println(new Solution().calculate(str));
    }
}

//有括号版本

/**
 * class Solution {
 * public int calculate(String s) {
 * int num = 0;
 * boolean flag = false;
 * boolean isFlag = false;
 * Stack<Integer> numStack = new Stack<>();
 * Stack<Character> stack = new Stack<>();
 * for (int i = 0; i < s.length(); i++) {
 * char c = s.charAt(i);
 * if (c == ' ') {
 * continue;
 * }
 * if (c == '+' || c == '-') {
 * if (flag) {
 * numStack.push(num);
 * num = calDouble(numStack, stack);
 * flag = false;
 * }
 * if (isFlag) {
 * numStack.push(-num);
 * isFlag = false;
 * } else {
 * numStack.push(num);
 * }
 * if (c == '-') {
 * isFlag = true;
 * }
 * num = 0;
 * stack.push('+');
 * } else if (c == '(') {
 * flag = false;
 * stack.push(c);
 * } else if (c == '*' || c == '/') {
 * if (flag) {
 * numStack.push(num);
 * num = calDouble(numStack, stack);
 * }
 * if (isFlag) {
 * numStack.push(-num);
 * isFlag = false;
 * } else {
 * numStack.push(num);
 * }
 * num = 0;
 * flag = true;
 * stack.push(c);
 * } else if (c == ')') {
 * numStack.push(num);
 * while (stack.peek() != '(') {
 * int cal = calDouble(numStack, stack);
 * numStack.push(cal);
 * }
 * stack.pop();
 * if (stack.peek() == '*' || stack.peek() == '/') {
 * int cal = calDouble(numStack, stack);
 * numStack.push(cal);
 * }
 * num = numStack.pop();
 * flag = false;
 * } else {
 * num = num * 10 + (c - '0');
 * }
 * }
 * if (isFlag) {
 * numStack.push(-num);
 * } else {
 * numStack.push(num);
 * }
 * char top;
 * while (!stack.empty()) {
 * int cal = calDouble(numStack, stack);
 * numStack.push(cal);
 * }
 * return numStack.pop();
 * }
 * <p>
 * //返回计算值
 * private int cal(int num1, int num2, char slogan) {
 * switch (slogan) {
 * case '+':
 * return num1 + num2;
 * case '-':
 * return num2 - num1;
 * case '*':
 * return num1 * num2;
 * default:
 * return num1 / num2;
 * }
 * }
 * <p>
 * //弹出两个数返回计算值
 * private int calDouble(Stack<Integer> numStack, Stack<Character> stack) {
 * int num2 = numStack.pop();
 * int num1 = numStack.pop();
 * return cal(num1, num2, stack.pop());
 * }
 * }
 */
//无括号版本
class Solution {
    public int calculate(String s) {
        int num = 0;
        char flag = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (flag) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                num = 0;
                flag = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}