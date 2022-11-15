package test.test2469;

/**
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），
 * 并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 * https://leetcode.cn/problems/convert-the-temperature/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test2469
 * @create 2022-11-15-10:30
 */
public class Test2469 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }
}