import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className PACKAGE_NAME
 * @create 2022-09-27-21:02
 */
public class Number2 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = new String();
        while (in.hasNextLine()) {
            // 注意 while 处理多个 case
            str = in.nextLine();
        }
        for (int i = 0; i < str.length(); i++) {
            search(str, i, i);
            search(str, i, i + 1);
        }
        list.sort(Comparator.comparingInt(String::length));
        for (String res : list) {
            System.out.println(res);
        }
    }

    private static void search(String s, int l, int r) {
        //   aba   adaddada
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            list.add(s.substring(l, r + 1));
            l--;
            r++;
        }
    }
}
