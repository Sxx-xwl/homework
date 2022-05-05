package test1672;

/**
 * @author sxx_27
 * @create 2022-04-14 19:15
 */
public class Test1672 {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3},{2,3,2}};
        int res = new Solution().maximumWealth(arr);
        System.out.println(res);

    }

}
class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxC = 0;
        for (int i = 0; i < accounts.length; i++) {
            int max = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                max += accounts[i][j];
            }
            maxC = maxC > max ? maxC : max;
        }
        return maxC;
    }
}