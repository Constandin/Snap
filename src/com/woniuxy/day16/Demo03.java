package com.woniuxy.day16;
import java.util.List;

public class Demo03 {
    public static List<User> nameArray(List<User> users){

        for(int i=0; i<users.size(); i++){
            User temp;
            for(int j=0; j<users.size() - 1; j++){
                if(users.get(i).getName().length()< users.get(i + 1).getName().length()){
                    temp = users.get(i+1);
                    users.set(i+1,users.get(i));
                    users.set(i,temp);
                }
            }

        }
        return users;
    }
}
