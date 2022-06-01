package test.test0954;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足
 * “对于每个 0 <=i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]”时，
 * 返回 true；否则，返回 false。
 * @author sxx_27
 * @create 2022-04-01 14:54
 */
public class Test0954 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {2,3,4,5,6,10};
        boolean b = s.canReorderDoubled(arr);
        System.out.println(b);

    }

}
class Solution {
    public boolean canReorderDoubled0(int[] arr) {

        int count = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int left = arr[0];
        int right = arr[0];
        int flag = 0;
        while (flag == 0)
        {
            flag = 1;
            if (set.contains(left / 2))
            {
                set.remove(left / 2);
                flag = 0;
                count++;
                left = left / 2;
            }
            if (set.contains(right * 2))
            {
                set.remove(right * 2);
                flag = 0;
                count++;
                right = right * 2;
            }
        }
        if (count == arr.length / 2)
        {
            return true;
        }
        return false;
    }

    public boolean canReorderDoubled1(int[] arr) {

        boolean isDouble = true;
        if (arr.length == 0) {
            return false;
        }
        int[] temp1 = new int[arr.length / 2];
        int[] temp2 = new int[arr.length / 2];
        Arrays.sort(arr);
        int num = 0;
        for (int i = 0; i < arr.length; i += 2) {
            temp1[num] = arr[i];
            if (num > 0 && temp1[num] != temp1[num - 1] / 2 && temp1[num] != temp1[num - 1] * 2) {
                isDouble = false;
            }
            temp2[num] = arr[i + 1];
            if (num > 0 && temp2[num] != temp2[num - 1] / 2 && temp2[num] != temp2[num - 1] * 2) {
                isDouble = false;
            }
            num++;
        }
        if (isDouble) {
            return isDouble;
        }
        if (arr[arr.length / 2 - 1] < 0 && arr[arr.length / 2] < 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && i < arr.length / 2 && arr[i] != arr[i - 1] / 2) {
                    return false;
                } else if (i > arr.length / 2 && arr[i] != arr[i - 1] / 2) {
                    return false;
                }
            }
        } else if (arr[arr.length / 2 - 1] < 0 && arr[arr.length / 2] >= 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && i < arr.length / 2 && arr[i] != arr[i - 1] / 2) {
                    return false;
                } else if (i > arr.length / 2 && arr[i] != arr[i - 1] * 2) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && i < arr.length / 2 && arr[i] != arr[i - 1] * 2) {
                    return false;
                } else if (i > arr.length / 2 && arr[i] != arr[i - 1] * 2) {
                    return false;
                }
            }
        }
        return true;
    }  /*这是一个把偶数数组对半还能是两个2倍数组的判断程序 */

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, len = n;
        // len将arr分成负数区和非负数区两段：
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                len = i;
                break;
            }
        }
        if ((len & 1) != 0) {
            return false;
        }
        // 分别双指针滑动，检查负数区和非负数区是否符合：
        boolean[] used = new boolean[n];
        if (!check(arr, used, 0, len)) {
            return false; // 负数区不符合
        }
        return check(arr, used, len, n);
    }

    // 双指针滑动，检查arr[s ... e]是否符合要求
    private static boolean check(int[] arr, boolean[] used,
                                 int s, int e) {
        int l = s, r = s + 1;
        while (l < e) {
            if (used[l]) { // l位置已被r匹配过，不能再用了
                l++;
                continue;
            }
            if (l >= r) {
                r = l + 1;
            }
            // r不断向右滑动，直到与[l]能匹配上，或者越界（无法匹配）为止
            // 需要区分负数区和非负数区的匹配条件不同：
            while (r < e && ((arr[r] < 0 && 2 * arr[r] < arr[l])
                    || (arr[r] >= 0 && arr[r] < 2 * arr[l]))) {
                r++;
            }
            if (r == e || ((arr[r] < 0 && 2 * arr[r] > arr[l])
                    || (arr[r] >= 0 && arr[r] > 2 * arr[l]))) {
                return false;
            }

            // [r] 与 [l] 匹配上：
            used[r] = true;
            l++;
            r++;
        }
        return true;
    }
}