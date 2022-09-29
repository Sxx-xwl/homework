package tree.binarytree0703;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0703
 * @create 2022-09-29-22:04
 */
public class Binarytree0703 {
    public static void main(String[] args) {

    }
}

class KthLargest {
    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for(int i: nums){
            queue.offer(i);
        }
    }

    public int add(int val) {
        if (queue.size()<k){
            queue.offer(val);
        }else if (queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}