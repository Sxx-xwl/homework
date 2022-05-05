package test155;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author sxx_27
 * @create 2022-02-26 19:29
 */
public class Test155 {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.getMin());
        minStack.push(-7);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }

}

class MinStack {

    Stack<Integer> arr = new Stack<>();
    int min;
    int top = -1;

    public MinStack() {


    }

    public void push(int val) {

        if (arr.isEmpty())
        {
            min = val;
        }else
        {
            min = min < val ? min : val;
        }
        arr.push(val);
        arr.push(min);
        top += 2;
    }

    public void pop() {

        arr.pop();
        arr.pop();
        top -= 2;
        if (top>0)
        {
            min = arr.get(top);
        }
    }

    public int top() {

        return arr.get(top-1);
    }

    public int getMin() {

        return arr.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
