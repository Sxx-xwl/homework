package test.test0075;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * @author sxx_27
 * @create 2022-03-13 21:25
 */
public class Test0075 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int arr[] = {2,0,2,1,1,0};
//        int arr[] = {0,0,2,0,2,1,1,0,2,2,2,1,2};
//        int arr[] = {1,2,0};
//        int arr[] = {2, 0, 1};
        solution.sortColors1(arr);

    }
}

class Solution {
    public void sortColors(int[] nums) {

        int minC = 0;
        int maxC = nums.length - 1;
        for (int i = 0; i < maxC + 1; i++) {

            if (nums[i] == 0 && i != 0) {
                while (nums[minC] == 0 && minC < i) {
                    minC++;
                }
                if (minC == i) {
                    continue;
                }
                nums[i] = nums[minC] ^ nums[i];
                nums[minC] = nums[minC] ^ nums[i];
                nums[i] = nums[minC] ^ nums[i];
                minC++;
                i--;
            } else if (nums[i] == 2 && i != maxC) {
                while (nums[maxC] == 2 && maxC > i) {
                    maxC--;
                }
                if (maxC == i) {
                    continue;
                }
                nums[i] = nums[maxC] ^ nums[i];
                nums[maxC] = nums[maxC] ^ nums[i];
                nums[i] = nums[maxC] ^ nums[i];
                maxC--;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors1(int[] nums) {

        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }
}