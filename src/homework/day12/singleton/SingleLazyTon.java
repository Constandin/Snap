package homework.day12.singleton;

public class SingleLazyTon {
    private static SingleLazyTon singleLazyTon;
    private SingleLazyTon(){

    }

    public static SingleLazyTon getInstance(){
        if(singleLazyTon == null){
            singleLazyTon = new SingleLazyTon();
        }
        return singleLazyTon;
    }
}
