package test.test448;

import java.util.ArrayList;
import java.util.List;

/**给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @author sxx_27
 * @create 2022-02-28 11:25
 */
public class Test448 {


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,1};
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);


    }

}
class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        int temp ;
        for (int i = 0; i < len; i++) {
            temp = nums[i]%len;
            nums[temp]= nums[temp]+len;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
                if (nums[i] <= len)
                {
                    list.add(i == 0 ? len : i);
                }
        }

        return list;

    }
}