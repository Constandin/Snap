package homework.day13;
import java.util.Scanner;
public class StringArrayTest {
    public static void main(String[] args) {
        StringArray s = new StringArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串数据");
        String str = sc.next();
        System.out.println("字符串数据逆向输出为\n" + s.stringArray(str));
    }
}
