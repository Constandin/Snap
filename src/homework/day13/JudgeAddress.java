package homework.day13;

public class JudgeAddress {
    public static boolean judgeAddress(String s){
        boolean is = true;
        int indexOfAt = 0,indexOfDot = 0;
        //去掉所有空格；
        String str = s.replace(" ","");

        // 判断@位置及重复情况；
        boolean judgeAt = str.indexOf("@") != 0 || str.indexOf("@") != str.length() - 1 && (str.indexOf("@") == str.lastIndexOf("@"));
        // 判断.位置及重复情况；
        boolean judgeDot = str.indexOf(".") != 0 || str.indexOf(".") != str.length() - 1 && (str.indexOf(".") == str.lastIndexOf("."));

        if (str.length() > 2) {
            if (judgeAt && judgeDot) {
                //输出@ ，. 索引位置；
                indexOfAt = str.indexOf("@");
                indexOfDot = str.indexOf(".");
            } else {
                is = false;
            }
        } else {
            is = false;
        }

        // 判断.是否在@后至少两位
        if(indexOfAt + 1 > indexOfDot){
            is = false;
        }
        return is;
    }
    //  QuickTest
    public static void main(String[] args) {
        System.out.println(JudgeAddress.judgeAddress(""));

    }
}
