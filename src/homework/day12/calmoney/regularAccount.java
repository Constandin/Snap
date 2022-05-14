package homework.day12.calmoney;

public class regularAccount extends Account {
    public regularAccount(double money,int year){
        super(money,year);
    }

    @Override
    public double getInterest(int year) {

        return getMoney() * (Math.pow(1.06,year) - 1);
    }
}
