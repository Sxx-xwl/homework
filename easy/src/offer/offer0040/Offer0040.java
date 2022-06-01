package offer.offer0040;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 * @author sxx_27
 * @create 2022-05-04 15:15
 */
public class Offer0040 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().getLeastNumbers(new int[]{0, 1, 2, 1,1,8}, 4)));
        System.out.println(Arrays.toString(new Solution().getLeastNumbers0(new int[]{0, 1, 2, 1,1,8}, 4)));
    }
}

class Solution {
    public int[] getLeastNumbers0(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        Queue<Integer> queue = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (i >= k && temp < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            } else if (i < k) {
                queue.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }else if (k>=arr.length){
            return arr;
        }
        QSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private int[] QSort(int[] arr, int l, int r, int k) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, l, i);
        if (i == k) {
            return Arrays.copyOf(arr, k);
        } else if (i < k) {
            return QSort(arr, i + 1, r, k);
        } else {
            return QSort(arr, l, i - 1, k);
        }
    }
}