package test0039;

import java.util.*;

/**给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 找出candidates中可以使数字和为目标数target 的所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * @author sxx_27
 * @create 2022-03-17 22:11
 */
public class Test0039 {

    public static void main(String[] args) {

        Solution s = new Solution();
//        int arr[] = {2};
        int arr[] = {1};
        List<List<Integer>> list = s.combinationSum(arr, 2);
        list.forEach(System.out::println);

    }

}
class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking(target, candidates, 0, list, 0, listList);

        return listList;
    }


    public void backtracking(int target, int[] candidates, int sum, List<Integer> list, int begin, List<List<Integer>> listList) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {

            if (sum > target) {
                break;
            }
            list.add(candidates[i]);
            backtracking(target, candidates, sum + candidates[i], list, i, listList);
            list.remove(list.size() - 1);
        }
    }
}