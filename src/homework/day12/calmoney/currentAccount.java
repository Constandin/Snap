package homework.day12.calmoney;

public class currentAccount extends Account {
    public currentAccount(double money,int year){
        super(money,year);
    }

    @Override
    public double getInterest(int year) {

        return getMoney() * (Math.pow(1.15,year) - 1);
    }
}
