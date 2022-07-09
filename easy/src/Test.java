import java.util.Arrays;

/**
 * @Classname Test
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/6/21 21:34
 * @Created by su
 */
public class Test {
    public static void main(String[] args) {
        int arr[] = new int[36];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (1000));
        }
        System.out.println(Arrays.toString(new AllSort().sort1(arr)));
        System.out.println(Arrays.toString(new AllSort().sort2(arr)));

//        Test test = new Test();
//        int i = 0;
//        test.add(i);
//        i = i++;
//        System.out.println(i);
//
//    }
//    void add(int i){
//        i++;
    }
}
class AllSort {
    /**
     * @Description: 冒泡排序
     * @Param: [arr]
     * @return: int[]
     * @Author: Sxx_xwl
     * @Date: 2022/6/21_21:43
     */
    public int[] sort1(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * @Description: 选择排序
     * @Param: [arr]
     * @return: int[]
     * @Author: Sxx_xwl
     * @Date: 2022/6/21_21:52
     */
    public int[] sort2(int[] arr) {
        int index = 0;
        int len = arr.length;
        boolean flag = true;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                    flag = false;
                }
            }
            if (!flag){
                exchange(arr, i, index);
                flag = true;
            }
        }
        return arr;
    }

    /**
     * @Description: 交换两数顺序
     * @Param: [arr, i, j]
     * @return: void
     * @Author: Sxx_xwl
     * @Date: 2022/6/21_22:11
     */
    static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}