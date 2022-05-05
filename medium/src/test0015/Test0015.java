package test0015;

import java.util.*;

/**给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *注意：答案中不可以包含重复的三元组。        [-4  -1  -1  0  1  2]
 * @author sxx_27
 * @create 2022-03-08 19:38
 */
public class Test0015 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {-4 , -1 ,-1 ,0 ,1 ,2 };
        List<List<Integer>> listList = solution.threeSum(arr);
        System.out.println(listList);
        List<List<Integer>> listList1 = solution.threeSum1(arr);
        System.out.println(listList1);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 3)
        {
            return new ArrayList<>();
        }
        if (length == 3 && nums[0]+nums[1]+nums[2]==0)
        {
            list.add(new ArrayList<>(Arrays.asList(nums[0],nums[1],nums[2])));
            return list;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        if (nums[0]>0 || nums[length-1]<0)
        {
            return new ArrayList<>();
        }
        int count ;
        int flag ;
        for (int i = 0; i < length; i++) {
            if (i>0&&nums[i-1] == nums[i])
            {
                continue;
            }
            flag = 0 - nums[i];
            Set<Integer> set = new HashSet();
            for (int j = i+1; j < length; j++) {
                count = flag - nums[j];
                if (set.contains(count)) {
                    list.add(Arrays.asList(nums[i], nums[j], count));
                    set.remove(count);
                    if (count == nums[j])
                    {
                        while (nums[j]==nums[j-1])
                        {
                            j++;
                        }
                    }
                }else {
                    set.add(nums[j]);
                }
            }
        }
        return list;
    }  //还是不行

    public List<List<Integer>> threeSum1(int[] nums){

        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 3)
        {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0]>0 || nums[length-1]<0)
        {
            return new ArrayList<>();
        }
        int count;
        for (int i = 0; i < length - 2; i++) {
            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = length-1;
            count = 0 - nums[i];
            while (l < r)
            {
                if (count==nums[l]+nums[r])
                {
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l]==nums[l+1])
                    {
                        l++;
                    }
                    while (l<r && nums[r]==nums[r-1])
                    {
                        r--;
                    }
                    l++;
                    r--;
                }else if (count<nums[l]+nums[r])
                {
                    r--;
                }else {
                    l++;
                }
            }
        }

        return list;
    }
}
