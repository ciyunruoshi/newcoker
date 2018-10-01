package assignApple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
//		Scanner in = new Scanner(System.in);
//		int n= in.nextInt();
//		in.nextLine();
//		int[] ai = new int[n];
//		int sum=0;
//		int apple = 0;
//		for(int i=0;i<n;i++) {
//			ai[i]=in.nextInt();
//			sum+=ai[i];
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int sum=0;
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);
            int[] ai = new int[n];
            line = br.readLine();
            String[] s = line.trim().split(" ");
          
            for(int i=0;i<n;i++){
                ai[i] = Integer.parseInt(s[i]);
                sum+=ai[i];
            }
	        int apple = 0;
			apple=sum/n;
			if(sum%n!=0) {
				System.out.println(-1);
				return;
			}
			sum=0;
			for(int i=0;i<n;i++) {
				if((ai[i]-apple)%2!=0) {
					System.out.println(-1);
					return ;
				}
				//ai[i]=Math.abs(ai[i]-apple);
				sum+=Math.abs(ai[i]-apple);
			}
		System.out.println(sum/4);
        }
		
	}
}
