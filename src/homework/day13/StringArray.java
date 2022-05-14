package homework.day13;


import java.util.ArrayList;

public class StringArray {

    public  String stringArray(String s){
        ArrayList<String> invertOrder  = new ArrayList<>();
        String str = "";
        if(s == null){
            return "请重新输入";
        } else {
            // 逆序输入数组；
            for (int i = s.length() - 1; i >= 0; i--){
                invertOrder.add(String.valueOf(s.charAt(i)));
            }
            // 顺序拼接；
            for(int i = 0;i < s.length();i++){
                str = str.concat(invertOrder.get(i));
            }
            return str;
        }
    }
}
