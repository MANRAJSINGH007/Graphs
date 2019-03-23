import java.util.*;

class Pair{
    
    int x;
    int y;    
    
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {

    static int mod=(int)Math.pow(10,9)+7;
    
    public static long fact(int n) {
        long res=1;
        while (n > 1) {
            res=((res%mod)*(n%mod))%mod;
            n--;
        }
        
        return res;
    }
    
    public static int dfs(boolean[][] visited, int[][] arr, int n, int m, int i, int j){
        
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || arr[i][j]==0){
            return 0;
        }
        
        visited[i][j]=true;
        
        int m1=dfs(visited,arr,n,m,i+1,j+2);
        int m2=dfs(visited,arr,n,m,i-1,j+2);
        int m3=dfs(visited,arr,n,m,i+2,j+1);
        int m4=dfs(visited,arr,n,m,i-2,j+1);
        int m5=dfs(visited,arr,n,m,i+1,j-2);
        int m6=dfs(visited,arr,n,m,i-1,j-2);
        int m7=dfs(visited,arr,n,m,i+2,j-1);
        int m8=dfs(visited,arr,n,m,i-2,j-1);
        
        return m1+m2+m3+m4+m5+m6+m7+m8+1;
        
    }
    
    public static int bfs(boolean[][] visited, int[][] arr, int n, int m, int i, int j){
        
        Queue<Pair> q=new LinkedList<Pair>();
        
        q.add(new Pair(i,j));
        visited[i][j]=true;
        int cnt=0;
        
        while(!q.isEmpty()){
            
            Pair obj=q.remove();
            cnt++;
            int xx=obj.x;
            int yy=obj.y;
            
            if(xx+1>=0 && yy+2>=0 && xx+1<n && yy+2<m && !visited[xx+1][yy+2] && arr[xx+1][yy+2]==1){
                
                visited[xx+1][yy+2]=true;
                q.add(new Pair(xx+1,yy+2));
                
            }
            if(xx-1>=0 && yy+2>=0 && xx-1<n && yy+2<m && !visited[xx-1][yy+2] && arr[xx-1][yy+2]==1){
                
                visited[xx-1][yy+2]=true;
                q.add(new Pair(xx-1,yy+2));
                
            }
            if(xx+2>=0 && yy+1>=0 && xx+2<n && yy+1<m && !visited[xx+2][yy+1] && arr[xx+2][yy+1]==1){
                
                visited[xx+2][yy+1]=true;
                q.add(new Pair(xx+2,yy+1));
                
            }
            if(xx-2>=0 && yy+1>=0 && xx-2<n && yy+1<m && !visited[xx-2][yy+1] && arr[xx-2][yy+1]==1){
                
                visited[xx-2][yy+1]=true;
                q.add(new Pair(xx-2,yy+1));
                
            }
            
            if(xx+1>=0 && yy-2>=0 && xx+1<n && yy-2<m && !visited[xx+1][yy-2] && arr[xx+1][yy-2]==1){
                
                visited[xx+1][yy-2]=true;
                q.add(new Pair(xx+1,yy-2));
                
            }
            if(xx-1>=0 && yy-2>=0 && xx-1<n && yy-2<m && !visited[xx-1][yy-2] && arr[xx-1][yy-2]==1){
                
                visited[xx-1][yy-2]=true;
                q.add(new Pair(xx-1,yy-2));
                
            }
            if(xx+2>=0 && yy-1>=0 && xx+2<n && yy-1<m && !visited[xx+2][yy-1] && arr[xx+2][yy-1]==1){
                
                visited[xx+2][yy-1]=true;
                q.add(new Pair(xx+2,yy-1));
                
            }
            if(xx-2>=0 && yy-1>=0 && xx-2<n && yy-1<m && !visited[xx-2][yy-1] && arr[xx-2][yy-1]==1){
                
                visited[xx-2][yy-1]=true;
                q.add(new Pair(xx-2,yy-1));
                
            }
            
            
        }
        
        return cnt;
        
        
    }
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++){
            
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            int arr[][]=new int[n][m];
            
            int q=sc.nextInt();
            
            for(int i=0;i<q;i++){
                
                int x=sc.nextInt();
                int y=sc.nextInt();
                x--;
                y--;
                arr[x][y]=1;
                
            }
            
            boolean visited[][]=new boolean[n][m];
            
            long result=1;
            
            for(int i=0;i<n;i++){
                
                for(int j=0;j<m;j++){
                    
                    if(!visited[i][j] && arr[i][j]==1){
                        int size=bfs(visited,arr,n,m,i,j);
                        result=((result%mod)*(fact(size)%mod)%mod);
                        // System.out.println(size);
                        
                    }
                }
            }
            
            System.out.println(result);
            
            
        }

	}

}
