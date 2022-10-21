package test.test0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0901
 * @create 2022-10-21-16:05
 */
public class Test0901 {
    public static void main(String[] args) {

    }
}

class StockSpanner {
    List<Integer[]> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int index = list.size() - 1, res = 1;
        while (index >= 0) {
            Integer[] temp = list.get(index);
            if (temp[0] <= price) {
                index -= temp[1];
                res += temp[1];
            } else {
                break;
            }
        }
        list.add(new Integer[]{price, res});
        return res;
    }
}