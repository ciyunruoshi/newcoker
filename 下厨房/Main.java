package xiachufang;

import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String s;
        String[] sa;
        HashSet<String> set=new HashSet<>();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            s=in.nextLine();
            sa=s.split(" ");
            for(String k:sa)
                set.add(k);
        }
        System.out.println(set.size());
    }
}