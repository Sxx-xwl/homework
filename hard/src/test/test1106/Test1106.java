package test.test1106;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1106
 * @create 2022-11-05-16:00
 */
public class Test1106 {
    public static void main(String[] args) {
        String s = "!(&(f,t))";
        System.out.println(new Solution().parseBoolExpr(s));
    }
}

class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> booleanStack = new LinkedList();
        Deque<Character> exprStack = new LinkedList();
        for (char c : expression.toCharArray()) {
            if (c == ',') continue;
            if (c == '|' || c == '&' || c == '!') {
                booleanStack.push(c);
            } else if (c == ')') {
                boolean cur = exprStack.pop() == 'f' ? false : true;
                char flag = booleanStack.pop();
                while (exprStack.peek() != '(') {
                    boolean temp = exprStack.pop() == 'f' ? false : true;
                    switch (flag) {
                        case '|':
                            cur = temp | cur;
                            break;
                        case '!':
                            cur = !cur;
                            break;
                        default:
                            cur = temp & cur;
                    }
                }
                exprStack.pop();
                if (flag == '!') cur = !cur;
                exprStack.push(cur ? 't' : 'f');
            } else {
                exprStack.push(c);
            }
        }
        return exprStack.peek() == 't';
    }
}