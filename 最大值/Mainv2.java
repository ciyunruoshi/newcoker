package maxium;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

/*
 * 采用计数排序，运行时间56ms,9000k
 * 优化采用快速排序
 */

public class Mainv2{
	public static final int offset=20;
    
    public static void exch(String[] list,int i,int j) {
    	String k = list[i];
    	list[i]=list[j];
    	list[j]=k;
    }
    public static String middle(String[] list,int start,int end) {
    	int mid = start+(end-start)/2;
    	if(!com(list[start],list[mid]))
    		exch(list,start,mid);
    	else if(!com(list[mid],list[end]))
    		exch(list,mid,end);
    	else if(com(list[start],list[mid]))
    		exch(list,start,mid);
    	exch(list,mid,end-1);
    	return list[end-1];
    }
    public static boolean com(String i1,String i2) {
    	if(i1.equals(i2))
    		return false;
    	int len1=i1.length();
    	int len2 = i2.length();
    	int len = (len1<=len2)? len1:len2;
    	
    	for(int i=0;i<len;i++) {
    		char c1=i1.charAt(i);
    		char c2=i2.charAt(i);
    		if(c1<c2)
    			return true;
    		else if(c1>c2)
    			return false;
    	}
    	if(len1>len2) {
    		for(int j=len;j<len1;j++) {
    			if(i1.charAt(j)<i1.charAt(j-len))
    				return  true;
    			else if(i1.charAt(j)>i1.charAt(j-len))
    				return false;
    		}
    	}
    	else if(len1<len2) {
    		for(int j=len;j<len2;j++) {
    			if(i2.charAt(j)<i2.charAt(j-len))
    				return false;
    			else if(i2.charAt(j)>i2.charAt(j-len))
    				return true;
    		}
    	}else {
    		return false;
    	}
    	return false;
    	
    }
    
    
    public static void Insertsort(String[] list,int lo,int hi) {
    	for(int i=lo+1;i<=hi;i++) {
    		String tmp =list[i];
    		int j;
    		for(j=i;j>lo;j--) {	
    			if(com(tmp, list[j-1]))
    				list[j]=list[j-1];
    			else
    				break;
    		}
    		list[j]=tmp;
    	}
    }
    
    public static void mysort(String[] list,int start,int end) {
    	if((end-start+1)<offset) {
    		Insertsort(list,start,end);
    		return ;
    	}
    	if(start>end)
    		return ;
    	//快速排序
    	String p = middle(list,start,end);
    	//String p=list[start];
    	int i=start+1;
    	int j = end-2;
    	while(i<j) {
    		while(com(list[i],p)) i++;
    		while(com(p,list[j])) j--;
    		if(i>j)
    			break;
    		exch(list, i, j);
    	}
    	exch(list,end-1,i);
    	mysort(list, start, i);
    	mysort(list, i+1, end);
    }
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n;
        String[] list;
        java.util.List<String> l = new LinkedList<>();
        while(in.hasNext()){
            n = in.nextInt();
            in.nextLine();
            list = new String[n];
            for(int i=0;i<n;i++)
                list[i]=in.next();
            in.nextLine();
            mysort(list,0,n-1);
            for(String k:list) {
            	l.add(k);
            }
            l.add("\n");
        }
        for(int i=l.size()-1;i>=0;i--)
        	System.out.print(l.get(i));
    }
}
//94794693939368608282177275872567266649636608590572554535523522413399
//94794693693938608218277275872567266649636608590572554535523522413399