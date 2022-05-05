package test0553;

/**给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如，[2,3,4] -> 2 / 3 / 4 。

 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。

 示例：

 输入: [1000,100,10,2]
 输出: "1000/(100/10/2)"

 * @author sxx_27
 * @create 2022-02-27 15:17
 */
public class Test0553 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.optimalDivision(new int[]{1000, 100, 10, 2});
        System.out.println(s);

    }

}
class Solution {
    public String optimalDivision(int[] nums) {

        if (nums.length==1)
        {
            return nums[0] + "";
        }else if (nums.length==2)
        {
            return  nums[0] + "/" + nums[1];
        }else {

            StringBuffer sb = new StringBuffer();
            sb.append(nums[0] + "/(");
            for (int i = 1; i < nums.length - 1; i++) {

                sb.append(nums[i] + "/");

            }
            sb.append(nums[nums.length-1] + ")");
            return String.valueOf(sb);
        }

    }
}