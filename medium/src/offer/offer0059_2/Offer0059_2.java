package offer.offer0059_2;

import java.util.*;

/**请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * @author sxx_27
 * @create 2022-05-28 10:29
 */
public class Offer0059_2 {


}

class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();//删除并返回最后一个元素
        }
        d.offerLast(value);
        q.offer(value); //向尾部插入元素
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();//删除并返回第一个元素
        if (ans == d.peekFirst()) {
            d.pollFirst();//删除并返回第一个元素
        }
        return ans;
    }
}
