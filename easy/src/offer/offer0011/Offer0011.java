package offer.offer0011;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]
 * 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * @author sxx_27
 * @create 2022-04-26 21:20
 */
public class Offer0011 {

    public static void main(String[] args) {

        int[] arr = {3, 1, 3};
        System.out.println(new Solution().minArray(arr));

    }
}

class Solution {
    public int minArray0(int[] numbers) {

        int len = numbers.length;
        if (numbers[0] < numbers[len - 1]) {
            return numbers[0];
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int minArray(int[] numbers) {

        int len = numbers.length;
        if (numbers[0] < numbers[len - 1] || len == 1) {
            return numbers[0];
        }
        int l = 0;
        int r = len - 1;
        int min;
        while (l <= r) {
            if (l == r) {
                return numbers[l];
            }
            min = (l + r) >> 1;
            if (numbers[min] > numbers[r]) {
                l = min + 1;
            } else if (numbers[min] < numbers[r]) {
                r = min;
            } else {
                if (numbers[l] == numbers[r]) {
                    l++;
                    r--;
                } else {
                    r = min;
                }
            }
        }
        return numbers[l];
    }
}