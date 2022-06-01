package test.test0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author sxx_27
 * @create 2022-03-10 20:31
 */
public class Test0017 {


    public static void main(String[] args) {

        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations1("23");
        strings.forEach(s -> System.out.println(s));

    }

}
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0||digits==null)
        {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> list = new ArrayList<>();
        list.add("");

        char[] chars = digits.toCharArray();

        String str ;
        int length = chars.length;
        int times = list.size();
        int flag = 0;
        while (flag<length)
        {
            for (int j = 0; j < times; j++) {
                String s = map.get(Integer.parseInt(String.valueOf(chars[flag])));
                str = list.get(0);
                list.remove(0);
                for (int i = 0; i < s.length(); i++) {
                    list.add(str + s.substring(i, i + 1));
                }
            }
            times = list.size();
            flag++;
        }
        return list;
    }

    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations1(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        backtrack(digits, new StringBuilder(), 0);
        return res;
    }

    //递归函数
    public void backtrack(String str, StringBuilder sb , int index){

        if (index == str.length())
        {
            res.add(sb.toString());
            return;
        }

        char c = str.charAt(index);
        int num = c - '0';

        for (int i = 0; i < letter_map[num].length(); i++) {
            sb.append(letter_map[num].charAt(i));
            backtrack(str, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if(index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for(int i=0;i<map_string.length();i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(map_string.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+map_string.charAt(i), index+1);
            iterStr(str, letter, index+1);
            letter.deleteCharAt(letter.length()-1);
        }
    }
}