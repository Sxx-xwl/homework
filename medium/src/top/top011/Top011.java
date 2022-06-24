package top.top011;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 *
 * @Classname Top011
 * @Version 1.0.0
 * @Date 2022/6/24 11:01
 * @Created by sxx_xwl
 */
public class Top011 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 1}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            max = Math.max(max, h * (r - l));
            if (height[l] >= height[r]) {
                while (h >= height[r] && l < r) {
                    r--;
                }
            } else {
                while (h >= height[l] && l < r) {
                    l++;
                }
            }
        }
        return max;
    }
}