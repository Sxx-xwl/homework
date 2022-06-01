package test.test283;

/**给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @author sxx_27
 * @create 2022-02-24 20:31
 */
public class Test283 {

    public static void main(String[] args) {

    Solution solution = new Solution();
    int[] nums = {0,0,1};
    for (int i : nums)
    {
        System.out.print(i + " ");
    };
        System.out.println();
    solution.moveZeroes(nums);
    }


}
class Solution {
    public void moveZeroes(int[] nums) {

        /*
        暴力解法
         */
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] == 0)
            {
                for (int j = i+1; j < nums.length; j++) {
                    {
                        if (nums[j]==0)
                        {
                            break;
                        }
                        nums[j-1] = nums[j-1] ^ nums[j];
                        nums[j] = nums[j-1] ^ nums[j];
                        nums[j-1] = nums[j-1] ^ nums[j];
                    }
                }
            }
        }
       for (int i : nums)
       {
           System.out.print(i + " ");
       };
    }
    /*
    双指针
     */
    public void moveZeroes1(int[] nums) {

        int i;
        int j;
        for (i = 0 ,j = 0; i < nums.length; i++) {
            if (nums[i]!=0)
            {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; k++) {
            nums[j]=0;
        }
       for (int k : nums)
       {
           System.out.print(k + " ");
       };
    }
    public void moveZeroes2(int[] nums) {

        for (int i = 0 ,j = 0; i < nums.length; i++) {
            if (nums[i]!=0)
            {
                if (j!=i)
                {
                    nums[j++] = nums[i];
                    nums[i]=0;
                }
            }
        }
        for (int k : nums)
        {
            System.out.print(k + " ");
        };
    }
}