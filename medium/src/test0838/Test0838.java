package test0838;

/**n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。

 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。

 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。

 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。

 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：

 dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。

 返回表示最终状态的字符串。
 * @author sxx_27
 * @create 2022-02-22 11:01
 */
public class Test0838 {


    public static void main(String[] args) {

        Solution solution = new Solution();
        String str = ".L.R.";
        System.out.println(str);
//        String s = solution.pushDominoes(str);
        String s = solution.official(str);
        System.out.println(s);

    }

}

class Solution {
    public String pushDominoes(String dominoes) {

        String str = "";
        while (!str.equals(dominoes)) {
            str = dominoes;
            dominoes = dominoes.replace("R.L", "SXX");
            dominoes = dominoes.replace("R.", "RR");
            dominoes = dominoes.replace(".L", "LL");
        }
        dominoes = dominoes.replace("SXX", "R.L");
        return dominoes;
    }

    public String official(String dominoes) {

        char[] chars = dominoes.toCharArray();
        int i = 0, n = chars.length;
        char left = 'L';
        int j = i;
        while (j < n)
        {
            while (j < n && chars[j]=='.')
            {
                j++;
            }
            char right = j < n ? chars[j] : 'R';
            if (right == left)
            {
                for (int k = i; k < j; k++) {
                    chars[k] = right;
                }
            }else if (right == 'L' && left == 'R')
            {
                for (int k = i, h = j; k < h ; k++,h--) {
                    chars[k] = left;
                    chars[h] = right;
                }
            }
            i = j;
            left = right;
            j++;
        }

        return new String(chars);
    }
}
