package offer0030;

import java.util.*;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author sxx_27
 * @create 2022-04-30 20:32
 */
public class Offer0030 {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}


class MinStack {
    Deque<Integer> inStack;
    Deque<Integer> minStack;

    public MinStack() {
        inStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
        minStack.push(Math.min(x, minStack.peek()==null?x:minStack.peek()));
    }

    public void pop() {
        minStack.pop();
        inStack.pop();
    }

    public int top() {
        return inStack.peek();
    }

    public int min() {

        return minStack.peek();
    }
}

