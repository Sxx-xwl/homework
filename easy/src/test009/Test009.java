package test009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sxx_27
 * @create 2022-01-14 19:37
 */
/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

示例 1：

输入：x = 121
输出：true

示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

 */
public class Test009 {


        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int x = Integer.parseInt(s);
                int xx = x;
                int temp = 0;
                if (x<0)
                {
                        System.out.println(false);
                }
                while (x!=0)
                {
                        temp = temp*10 + x%10;
                        x = x/10;
                }
                if (xx==temp)
                {
                        System.out.println(true);
                        System.out.println(xx + " " + temp);
                }
                else
                {
                        System.out.println(false);
                        System.out.println(xx + " " + temp);
                }
        }

}
