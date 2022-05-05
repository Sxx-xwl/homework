package test1863;

/**一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 例如，数组[2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 * @author sxx_27
 * @create 2022-03-23 15:45
 */
public class Test1863 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int arr[] = new int[]{1,3};
        int sum = solution.subsetXORSum(arr);
        System.out.println(sum);
    }

}


class Solution {

    int sum = 0;
    public int subsetXORSum(int[] nums) {

        if (nums.length == 0) {
            return nums[0];
        }

        backtracking(nums, 0, 0);
        return sum;
    }

    public void backtracking0(int[] nums, int len, int temp) {

        if (len == nums.length) {
            sum += temp;
            return;
        }

        backtracking(nums, len + 1, temp ^ nums[len]);
        backtracking(nums, len + 1, temp);
    }
    public void backtracking(int nums[] , int len , int temp){

        if (len == nums.length)
        {
            sum += temp;
            return;
        }

        backtracking(nums, len+1, temp^nums[len]);
        backtracking(nums, len+1, temp);

    }
}

//
//class Solution {
//
//    int sum = 0;
//    List<Integer> arr_num = new ArrayList<>();
//
//    public int subsetXORSum(int[] nums) {
//
//        arr_num.add(0);
//        int len = 0;
//        backtracking(nums , len);
//        for (int i = 0; i < arr_num.size(); i++) {
//            sum += arr_num.get(i);
//        }
//
//        return sum/2;
//    }
//
//    public void backtracking(int[] nums, int len){
//
//        while (len<nums.length) {
//            arr_num.add(nums[len]);
//            int le = arr_num.size() - 1;
//            for (int i = 0; i < le; i++) {
//
//                arr_num.add(arr_num.get(i) ^ nums[len]);
//            }
//            len++;
//        }
//    }
//}