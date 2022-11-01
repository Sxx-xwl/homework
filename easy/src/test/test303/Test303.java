package test.test303;

/**
 * 给定一个整数数组 nums，处理以下类型的多个查询:
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，
 * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test303
 * @create 2022-11-01-15:48
 */
public class Test303 {
    public static void main(String[] args) {

    }
}

class NumArray {
    private int[] sumNums;

    public NumArray(int[] nums) {
        sumNums = new int[nums.length + 1];
        for (int i = 1; i < sumNums.length; i++) {
            sumNums[i] = sumNums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sumNums[right + 1] - sumNums[left];
    }
}