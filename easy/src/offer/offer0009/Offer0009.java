package offer.offer0009;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author sxx_27
 * @create 2022-04-25 22:01
 */
public class Offer0009 {

}

class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            change();
        }
        return outStack.pop();
    }
    public void change(){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

