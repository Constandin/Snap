package homework.day18;

public class ExceptionNumDivision {
    public static void main(String[] args) {
        ExceptionNumDivision d = new ExceptionNumDivision();

        try {
            d.division(10,0);//虚拟机抛异常；
        } catch (Exception e) {
            // 记日志，给提示；
            System.out.println("系统维护中");
        }
    }

    public int division(int num1,int num2) throws Exception {
        if(num2 == 0){
            throw new Exception("除数为0");
        }
        else{return num1 / num2;}
    }
}
