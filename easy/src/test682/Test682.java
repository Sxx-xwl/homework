package test682;

import java.util.ArrayList;
import java.util.List;

/**你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 整数 x - 表示本回合新获得分数 x
 "+" - 表示本回合新获得的得分是   前两次  得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 "D" - 表示本回合新获得的得分是   前一次  得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 请你返回记录中所有得分的总和。
 * @author sxx_27
 * @create 2022-03-26 13:50
 */
public class Test682 {

    public static void main(String[] args) {
        
        Solution s = new Solution();
//        String[] ops = {"5","2","C","D","+"};
        String[] ops = {"1"};
        int i = s.calPoints(ops);
        System.out.println(i);

    }

}


class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (String str : ops)
        {
            switch (str){
                case "C":
                    list.remove(list.size()-1);
                    break;
                case "D":
                    int temp;
                    temp = list.get(list.size()-1) * 2;
                    list.add(temp);
                    break;
                case "+":
                    int two;
                    two = list.get(list.size()-1);
                    two += list.get(list.size()-2);
                    list.add(two);
                    break;
                default:
                    list.add(Integer.valueOf(str));
                    break;
            }
        }
        for (int i : list)
        {
            sum += i;
        }
        return sum;
    }
}