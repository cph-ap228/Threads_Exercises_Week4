package src;

import java.util.ArrayList;



public class Callable {
    
    private static ArrayList<String> list = new ArrayList<String>();
       
    public static void add(String s){
        list.add(s);
    }

    public static ArrayList<String> getList() {
        return list;
    }
    
    public static void printAll(){
        if(!list.isEmpty())
        for(String s: list){
            System.out.println(s);
        }
    }
    
}
