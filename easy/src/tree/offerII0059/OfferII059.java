package tree.offerII0059;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。
 * 注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.offerII0059
 * @create 2022-10-14-10:48
 */
public class OfferII059 {
    public static void main(String[] args) {

    }
}

class KthLargest {
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        return queue.peek();
    }
}
