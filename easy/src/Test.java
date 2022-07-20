import java.sql.Statement;
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
        int[] arr1 = new int[36];
        int[] arr2 = new int[36];
        int[] arr3 = new int[36];
        int[] arr4 = new int[36];
        for (int i = 0; i < arr4.length; i++) {
            arr1[i] = (int) (Math.random() * (1000));
            arr2[i] = (int) (Math.random() * (1000));
            arr3[i] = (int) (Math.random() * (1000));
            arr4[i] = (int) (Math.random() * (1000));
        }

        System.out.println(Arrays.toString(new AllSort().sort1(arr1)));
        System.out.println(Arrays.toString(new AllSort().sort2(arr2)));
        System.out.println(Arrays.toString(new AllSort().sort3(arr3)));
        System.out.println(Arrays.toString(new AllSort().sort4(arr4)));
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
            index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                    flag = false;
                }
            }
            if (!flag) {
                exchange(arr, i, index);
                flag = true;
            }
        }
        return arr;
    }

    /**
     * @Description: 归并排序
     * @Param: [arr]
     * @return: int[]
     * @Author: Sxx_xwl
     * @Date: 2022/7/17_13:54
     */
    public int[] sort3(int[] arr) {
        int[] temp = new int[arr.length];
        merge(temp, arr, 0, arr.length - 1);
        return arr;
    }

    private void merge(int[] temp, int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        int i = l, j = mid + 1, k = l;
        merge(temp, arr, i, mid);
        merge(temp, arr, j, r);
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        int p = l;
        while (p <= r) {
            arr[p] = temp[p++];
        }
    }

    /**
     * @Description: 快速排序
     * @Param: [arr]
     * @return: int[]
     * @Author: Sxx_xwl
     * @Date: 2022/7/19_16:31
     */
    public int[] sort4(int[] arr) {
        qucik(arr, 0, arr.length - 1);
        return arr;
    }

    private void qucik(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int index = start + 1;
        int l = start + 1;
        while (l <= end) {
            if (arr[l] < pivot) {
                exchange(arr, index++, l);
            }
            l++;
        }
        exchange(arr, index - 1, start);
        qucik(arr, start, index - 2);
        qucik(arr, index, end);
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