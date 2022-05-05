package test0011;

/**给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。

 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。
 * @author sxx_27
 * @create 2022-02-28 15:44
 */
public class Test0011 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {177,112,74,197,90,16,4,61,103,133,198
                ,4,121,143,55,138,47,167,165,159,93,85,53,118,
                127,171,137,65,135,45,151,64,109,25,61,152,194,65
                ,165,97,199,163,53,72,58,108,10,105,27,127,64,120,164,70,190,91,41,127,109,176,172,12,
                193,34,38,54,138,184,120,103,33,71,66,86,143,
                125,146,105,182,173,184,199,46,148,69,36,192,110,116,53,38,40,65,31,74,103,86,12,39,158};
        int i = solution.maxArea(arr);
        System.out.println(i);

    }


}
class Solution {

    public int maxArea(int[] height) {
        //如果就两个数直接返回面积
        if (height.length == 2) {
            return height[0] < height[1] ? height[0] : height[1];
        }

        int max = 0;  //最高点
        int left;       //左边指针
        int right;      //右边指针
        int lmax = 0, rmax = height.length - 1;  // 左右最高点的坐标
        int area;       //面积
        int maxArea;        //最大面积
        //  寻找全数组最高点
        for (int i = 0; i < height.length; i++) {
            max = height[i] > height[max] ? i : max;
        }
        // 从最高点往左走  找左边最高点
        for (int i = 0; i < max; i++) {
            lmax = height[i] > height[lmax] ? i : lmax;
        }
        // 从最高点往右走  找右边最高点
        for (int i = max + 1; i < height.length; i++) {
            rmax = height[i] > height[rmax] ? i : rmax;
        }
        //将左右两边最高点比较  选出高的 即为全数组第二高点  分别赋值给 rmax  lmax
        if (height[lmax] >= height[rmax]) {
            rmax = max;
        } else {
            lmax = max;
        }


        left = lmax;
        right = rmax;
        area = Math.min(height[lmax], height[rmax]) * (rmax - lmax);
        maxArea = area;
        //将最右边高点 向外扩
        for (int i = right + 1; i < height.length; i++) {
            //如果扩充后 增加的面积 比 扩充后减少的面积大  就将rmax移动到此点
            if ((Math.min(height[lmax], height[rmax]) - height[i]) * (rmax - lmax) < (i - rmax) * height[i]) {
                rmax = i;
                area = Math.min(height[lmax], height[rmax]) * (rmax - lmax);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        //将最左边高点 向外扩
        for (int i = left - 1; i >= 0; i--) {
            //如果扩充后 增加的面积 比 扩充后减少的面积大  就将lmax移动到此点
            if ((Math.min(height[lmax], height[rmax]) - height[i]) * (rmax - lmax) < (lmax - i) * height[i]) {
                lmax = i;
                area = Math.min(height[lmax], height[rmax]) * (rmax - lmax);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        for (int i = rmax + 1; i < height.length; i++) {
            //如果扩充后 增加的面积 比 扩充后减少的面积大  就将rmax移动到此点
            if ((Math.min(height[lmax], height[rmax]) - height[i]) * (rmax - lmax) < (i - rmax) * height[i]) {
                rmax = i;
                area = Math.min(height[lmax], height[rmax]) * (rmax - lmax);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        //返回最大面积
        return maxArea;

    }

    public int maxArea1(int[] height){

        int area;
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right)
        {
            area = Math.min(height[left],height[right]) * (right-left) ;
            maxArea = area > maxArea ? area : maxArea;
            if (height[left] <= height[right])
            {
                int temp = height[left];
                left++;
                while (temp > height[left])
                {
                    left++;
                }
            }else {
                int temp = height[right];
                right--;
                while (temp > height[right])
                {
                    right--;
                }
            }
        }

        return maxArea;
    }
}