package test.test0895;

import java.util.*;

/**
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * 实现 FreqStack 类:
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 * https://leetcode.cn/problems/maximum-frequency-stack/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0895
 * @create 2022-11-30-11:25
 */
public class Test0895 {
    public static void main(String[] args) {

    }
}

class FreqStack {
    //维护各个数字的频率
    private final Map<Integer, Integer> freq = new HashMap<>();
    //维护各个频率的栈
    private final List<Deque<Integer>> group = new ArrayList<>();

    public void push(int val) {
        int c = freq.getOrDefault(val, 0);
        //入栈
        if (c == group.size()) {
            group.add(new ArrayDeque<>());
        }
        group.get(c).push(val);
        //更新频率
        freq.put(val, c + 1);
    }

    public int pop() {
        //找到最高频率栈
        int back = group.size() - 1;
        //弹出最接近栈顶的元素
        int val = group.get(back).pop();
        //如果栈空了，移除栈
        if (group.get(back).isEmpty()) {
            group.remove(back);
        }
        //修改元素频率
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}