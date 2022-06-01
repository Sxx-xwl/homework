package offer.offer0062;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
 * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 * 因此最后剩下的数字是3。
 *
 * @author sxx_27
 * @create 2022-05-10 11:12
 */
public class Offer0062 {
    public static void main(String[] args) {

        System.out.println(new Solution().lastRemaining(5, 3));

    }
}

class Solution {
    public int lastRemaining0(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        int count = n;
        while (list.size() > 1) {
            index = (index + m - 1) % count;
            list.remove(index);
            count--;
        }
        return list.get(0);
    }

    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}