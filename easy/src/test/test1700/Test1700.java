package test.test1700;

/**
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第if个三明治的类型（i = 0是栈的顶部），
 * students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1700
 * @create 2022-10-19-11:22
 */
public class Test1700 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        //count 用来计算学生和喜欢的三明治不对应的个数
        int count = 0;
        for (int i = 0; i < sandwiches.length; i++) {
            count += students[i];
            count -= sandwiches[i];
        }
        //如果count == 0 说明每个学生都可以拿到喜欢的三明治
        if(count==0){
            return 0;
        }
        //count ！= 0 说明有一种三明治多
        // 如果count>0 说明是 0 三明治多了count个 否则是 1 三明治多-count
        //标记多的那个三明治
        int flag = count > 0 ? 0 : 1;
        //index 用来标记多出来count个的位置
        int index = 0;
        //从后往前查找多出来的第count个的位置
        //因为他是多出来的所以没人喜欢
        //因此从他到最后都是吃不到的 直接返回即可
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            if (flag == sandwiches[i]) index++;
            if (index == count || index + count == 0)
                return sandwiches.length - i ;
        }
        return 0;
    }
}