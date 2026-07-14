package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionSample {

    public static void collectionSample(){
    List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        for(int number : numbers){
            System.out.println(number);
        }

        List<String[]> users = new ArrayList<>();
        users.add(new String[]{"Admin", "admin123","Success"});
        users.add(new String[]{"Admin", "admin1234","Fail"});
        users.add(new String[]{"Admin123", "admin123","Fail"});

        for(String[] user : users){
    //        System.out.println(user[0]+" "+user[1]+" "+user[2]);
            System.out.println(Arrays.toString(user));
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing16");
        collectionSample();
    }
}
