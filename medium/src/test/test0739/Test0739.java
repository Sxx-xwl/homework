package test.test0739;

import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个整数数组temperatures，
 * 表示每天的温度，返回一个数组answer，
 * 其中answer[i]是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，
 * 请在该位置用0 来代替。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0739
 * @create 2022-10-21-16:35
 */
public class Test0739 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.add(i);
        }
        return res;
    }
}