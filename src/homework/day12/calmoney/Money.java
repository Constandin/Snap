package homework.day12.calmoney;
import java.util.Scanner;
public class Money {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入利息计算系统");
        System.out.println("请选择功能：\n 1. 定期利息；\n 2. 活期利息；\n 3. 退出");
        int option = sc.nextInt();

        while(true){
            switch(option){
                case 1:
                    System.out.println("请输入金额");
                    double money1 = sc.nextDouble();
                    System.out.println("请输入时间(年)");
                    int year1 = sc.nextInt();
                    currentAccount cur = new currentAccount(money1,year1);
                    System.out.println(cur.getMoneyAndInterest());
                    break;
                case 2:
                    System.out.println("请输入金额");
                    double money2 = sc.nextDouble();
                    System.out.println("请输入时间(年)");
                    int year2 = sc.nextInt();
                    regularAccount reg = new regularAccount(money2,year2);
                    System.out.println(reg.getMoneyAndInterest());
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;

        }


        }




    }
}
