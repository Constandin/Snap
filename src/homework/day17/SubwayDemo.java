/**
 * 1）地铁站编号和站名对应关系如下：
 * 1=天府广场
 * 2=省体育馆
 * 3=倪家桥
 * 4=火车南站
 * 5=孵化园
 * 6=世纪城
 * 7=天府三街
 * 8=天府五街
 * //….
 * 将以上对应关系的数据存储到map集合中，key：表示站编号，value：表示站名（不重复），并遍历打印(可以不按顺序打印)
 * <p>
 * 2）.计算地铁票价规则：
 * 总行程 3站内（包含3站）收费3元，
 * 3站以上但不超过5站（包含5站）的收费4元，
 * 5站以上的，在4元的基础上，每多1站增加2元，
 * 10元封顶；
 * <p>
 * 3）打印格式（需要对键盘录入的上车站和到达站进行判断，如果没有该站，提示重新输入，直到站名存在为止）
 * <p>
 * 注意：每站需要2分钟
 * 请输入上车站：科技馆
 * 您输入的上车站：科技馆 不存在，请重新输入上车站： 天府广场
 * 请输入到达站：科技馆
 * 您输入的到达站：科技馆 不存在，请重新输入到达站： 孵化园
 * <p>
 * 从天府广场到孵化园共经过4站收费4元，大约需要 8分钟
 */
package homework.day17;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubwayDemo {
    Map<Integer, String> station = new HashMap<>();

    public static void main(String[] args) {
        SubwayDemo s = new SubwayDemo();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入地铁查询系统");
        s.subwayStation();
        String s1,s2;
        while(true){
            System.out.println("请输入上车站");
             s1 = sc.next();
            if(!s.contain(s1)){continue;}
            System.out.println("请输入下车站");
             s2 = sc.next();
            if(!s.contain(s2)){continue;}
            if(s.contain(s1)&&s.contain(s2)){
                break;
            }
        }
        System.out.println(s.billAndTimeMethod(s1,s2));
    }

    // 导入站点信息
    public void subwayStation() {
        station.put(1, "天府广场");
        station.put(2, "省体育馆");
        station.put(3, "倪家桥");
        station.put(4, "火车南站");
        station.put(5, "孵化园");
        station.put(6, "世纪城");
        station.put(7, "天府三街");
        station.put(8, "天府五街");
        station.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    // 判断站名存在情况
    public boolean contain(String s) {
        boolean exist = true;
        if (!station.containsValue(s)) {
            System.out.println("站名不存在，请重新输入！");
            exist = false;
        }
        return exist;
    }

    // 计费计时方式
    public String billAndTimeMethod(String s1, String s2) {
        int bill = 0, time = 0;
        int key1 = 0, key2 = 0;
        for (int i = 1; i < station.size(); i++) {
            if (station.get(i).equals(s1)) {
                key1 = i;
            }
            if (station.get(i).equals(s2)) {
                key2 = i;
            }
        }
        int minus = Math.abs(key1 - key2) + 1;
        time = 2 * (minus - 1);
        if (minus <= 3) {
            bill = 3;
        } else if (minus <= 5) {
            bill = 4;
        } else {
            bill = Math.min(4 + (minus - 5) * 2, 10);
        }
        return "从" + s1 + "到" + s2 + "共经过" + (minus-1) + "站收费" + bill + "元，大约需要" + time + "分钟";
    }
}
