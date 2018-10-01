package fentiandi;

import java.util.Scanner;

/*
 * 二分法加暴力算法
 * 
 * 采用逼近方法，以1/16的价值k作为低价，执行遍历切法，一旦找到一种切法满足
 * 每块地的价值都比k高，继续增大k的值为1/8然后再次判断，或者没有满足的，1/8与1/16的二分
 * 再次遍历，知道上下限的到达一样的值，夹逼法
 */
public class Main {
	public final int[][] sum;
	public int n;
	public int m; 
	public int[] line;
	public int[] col;
	public int value=0;
	
	public Main(final int[][] s,int n,int m) {
		this.n = n;
		this.m=m;
		sum = s;
		line = new int[5];
		line[0]=-1;
		line[4]=n-1;
		col = new int[5];
		col[0]=-1;
		col[4]=m-1;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				value+=sum[i][j];
		int hi = value;
		int lo = 0;
		int res=0;
		while(hi>=lo) {
			value = (hi+lo)/2;
			//System.out.println("hi:"+hi+"lo:"+lo);
			
			if(cutofline()) {
				res=value;
				lo=value+1;
			}else {
				hi=value-1;
			}
			
		}
		System.out.println(res);
	}
	
	public boolean cutofline() {
		//System.out.println("要判断的值"+value);
		for(int i=0;i<n-3;i++) {//i=0 <4-3=1
			//System.out.println("第一次行"+i+"割");
			for(int j=i+1;j<n-2;j++) {//j=1 <4-2=2
				//System.out.println("第二次行"+j+"割");
				for(int k=j+1;k<n-1;k++) {//k=2 <4-1=3
						//N^3时间复杂度
					//System.out.println("第三次行"+k+"割");
					int last =-1;
					int c = 0;
					for(int lie=0;lie<m;lie++) {
						int l1=getArea(0,i,last+1,lie);//行上下限 列上下限
						int l2=getArea(i+1,j,last+1,lie);
						int l3=getArea(j+1,k,last+1,lie);
						int l4=getArea(k+1,n-1,last+1,lie);
						if(l1>=value&&l2>=value&&l3>=value&&l4>=value) {
							c++;
							last=lie;
						}
						if(c>=4)
							return true;
						
					}
					
				}
			}
		}
		return false;
	}
	
	
	public int getArea(int hangs,int hange,int lies,int liee) {
		int s =0;
		for(int i=hangs;i<=hange;i++)
			for(int j=lies;j<=liee;j++) {
				s+=sum[i][j];
				//System.out.println("序号："+i+"+"+j);
			}
		return s;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int m=in.nextInt();
		in.nextLine();
		int[][] cs= new int[n][m];
		for(int i=0;i<n;i++) {
			String string=in.nextLine();
			for(int j=0;j<m;j++)
				cs[i][j]=string.charAt(j)-'0';
		}
		Main nMain = new Main(cs, n, m);	
	}
}
