package maxium;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 采用计数排序，运行时间56ms,9000k
 */
public class Main{
	

    public static int atInt(int k,int index) {
    	while(k<100) {
    		if(k<10)
    			k=k*10+k;
    		else
    			k=k*10+k/10;
    	}
    	for(int i=2-index;i>0;i--)
                k=k/10;
        return k%10;
    }
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);  
        int n;
        int[] list;
        java.util.List<Integer> l = new LinkedList<>();
        int[] aux;
        int[] c;
        while(in.hasNext()){
            n = in.nextInt();
            in.nextLine();
            list = new int[n];
            aux=new int[n];
            for(int i=0;i<n;i++)
                list[i]=in.nextInt();
            in.nextLine();
            for(int i=2;i>=0;i--){
            	c=new int[11];
                for(int j=0;j<n;j++)
                    c[atInt(list[j],i)+1]++;
                for(int j=0;j<9;j++)
                    c[j+1]+=c[j];
                 for(int j=0;j<n;j++)
                     aux[c[atInt(list[j],i)]++]=list[j];
                for(int j=0;j<n;j++)
                    list[j]=aux[j];
            }
            for(int i=n-1;i>=0;i--)
               l.add(list[i]);
            l.add(-1);
        }
        for(Integer k:l)
        	if(k.equals(-1))
        		System.out.println();
        	else 
        		System.out.print(k);
        
    }}
//94794693939368608282177275872567266649636608590572554535523522413399
//94794693693938608218277275872567266649636608590572554535523522413399