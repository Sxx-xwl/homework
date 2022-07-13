package top.top146;

import java.util.*;

/**
 * 请你设计并实现一个满足LRU
 * (最近最少使用) 缓存约束的数据结构。
 * 实现LRUCache类：
 * LRUCache(int capacity)
 * 以正整数作为容量capacity初始化LRU缓存
 * int get(int key) 如果关键字key存在于缓存中，
 * 则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key已经存在，
 * 则变更其数据值value ；
 * 如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，
 * 则应该逐出最久未使用的关键字。
 * 函数get和put必须以O(1)的平均时间复杂度运行。
 *
 * @Classname Top146
 * @Version 1.0.0
 * @Date 2022/7/13 15:57
 * @Created by sxx_xwl
 */
public class Top146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class LRUCache {
    int maxC;
    Map<Integer, Integer> map = new LinkedHashMap<>();
    LinkedList<Integer> list = new LinkedList<>();

    public LRUCache(int capacity) {
        maxC = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        list.remove((Integer) key);
        list.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (get(key) == -1) {
            if (map.size() >= maxC) {
                map.remove(list.getFirst());
                list.removeFirst();
            }
            list.add(list.size(), key);
        }
        map.put(key, value);
    }
}
