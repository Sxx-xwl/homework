package top.top026;

/**
 * 给你一个 升序排列 的数组 nums ，
 * 请你 原地 删除重复出现的元素，
 * 使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，
 * 所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，
 * 那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在原地修改输入数组
 * 并在使用 O(1)额外空间的条件下完成。
 *
 * @author sxx_27
 * @create 2022-06-02 15:26
 */
public class Top026 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1}));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0||len == 1) {
            return len;
        }
        int index = 1;
        int i = 0;
        while (index < len) {
            if (nums[i] == nums[index]){
                index++;
            }else {
                nums[++i] = nums[index++];
            }
        }
        return i+1;
    }
}