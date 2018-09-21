package dilaotaotuo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Mainv2{
    private int[] nmove;
    private int[] mmove;
    private char[][] table;
    private boolean[][] marked;
    private int[][] movelist;
    private Queue<Integer> queue ;
    private int N;
    private int M;
    private int x,y;
    private int movenum;
    public Mainv2(){
    	queue = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        N=in.nextInt();
        M=in.nextInt();
        in.nextLine();
        table  = new char[N][M];
        marked=new boolean[N][M];
        movelist = new int[N][M];
        for(int i=0;i<N;i++) {
        	table[i]=in.nextLine().toCharArray();
        }
        x=in.nextInt();
        y=in.nextInt();
        in.nextLine();
        movenum=in.nextInt();
        nmove=new int[movenum];
        mmove=new int[movenum];
        for(int i=0;i<movenum;i++) {
        	nmove[i]=in.nextInt();
        	mmove[i]=in.nextInt();
        	in.nextLine();
        }
        System.out.println(exitnum());
    }
    public int exitnum() {
    	away();
    	int step=0;
    	for (int i=0;i<N;i++)
    		for(int j=0;j<M;j++)
    			if(movelist[i][j]>step&table[i][j]=='.') {
    				if(movelist[i][j]==Integer.MAX_VALUE)
    					return -1;
    				step=movelist[i][j];
    			}
		return step;
    }		
    
    public void away() {
    	//v1创建邻接表？深度优先搜索？直接使用移动的方案 测试通过，但是时间太久
    	//v2 舍弃空间，采用广度优先遍历
    	
    	for(int i=0;i<N;i++)
    		for(int j=0;j<M;j++)
    				movelist[i][j]=Integer.MAX_VALUE;
    	movelist[x][y]=0;
    	queue.add(x*M+y);
    	marked[x][y]=true;
    	int n=0;
    	int m=0;
    	while(!queue.isEmpty()) {
    		int tnp=queue.poll();
    		n=tnp/M;
    		m=tnp%M;
    		for(int i=0;i<movenum;i++){
        		if(isOk(n+nmove[i],m+mmove[i])) {
        			if(!marked[n+nmove[i]][m+mmove[i]]) {
        				tnp = (n+nmove[i])*M+m+mmove[i];
        			    movelist[n+nmove[i]][m+mmove[i]]=movelist[n][m]+1;
        				queue.add(tnp);
        				marked[n+nmove[i]][m+mmove[i]]=true;
        			}
        		}	
        	}
    	}
    }
    
    public boolean isOk(int n,int m) {
    	if(n<0||n>=N||m<0||m>=M) {
    		return false;
    	}else if(table[n][m]=='X'){
    		return false;
    	}
    	return true;
    }
    
    
    
    
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		Mainv2 aGoaway =new Mainv2();
    }
}