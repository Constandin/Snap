package homework.day12.singleton;

public class SingleHungryTon {
    //此处 static 为保证 getInstance 可以调用 singleHungryTon 这个对象；
    private static SingleHungryTon singleHungryTon = new SingleHungryTon();
    private  SingleHungryTon(){
    }

    //此处 static 为保证调用方法时，不用新创建对象，直接类打点即可调用；
    public static SingleHungryTon getInstance(){
        return singleHungryTon;
    }
}
