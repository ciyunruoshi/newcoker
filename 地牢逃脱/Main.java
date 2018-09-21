package dilaotaotuo;

import java.util.Scanner;
public class Main{
    private int[] nmove;
    private int[] mmove;
    private char[][] table;
    private boolean[][] marked;
    private int[][] movelist;
    private int N;
    private int M;
    private int x,y;
    private int movenum;
    public Main(){
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
    	// v2 舍弃空间，采用广度
    	
    	for(int i=0;i<N;i++)
    		for(int j=0;j<M;j++)
    			if(table[i][j]=='.')
    				movelist[i][j]=Integer.MAX_VALUE;
    	movelist[x][y]=0;
    	awayto(x,y);
    }
    
    private void awayto(int n,int m) {
    	marked[n][m]=true;
    	for(int i=0;i<movenum;i++){
    		if(isOk(n+nmove[i], m+mmove[i])) {
    			if(!marked[n+nmove[i]][m+mmove[i]]) {
    				if((movelist[n][m]+1)<movelist[n+nmove[i]][m+mmove[i]])
    					movelist[n+nmove[i]][m+mmove[i]]=movelist[n][m]+1;
    				awayto(n+nmove[i],m+mmove[i]);
    			}
    		}	
    	}
    	marked[n][m]=false;
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
		Main aGoaway =new Main();
    }
}