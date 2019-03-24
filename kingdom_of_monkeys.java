import java.util.*;

public class Main {

    public static int dfs(ArrayList<ArrayList<Integer>> edges, boolean[] visited, int sv, int[] bananas){
        
        visited[sv]=true;
        
        ArrayList<Integer> curr=edges.get(sv);
        
        int ans=bananas[sv];
        
        for(int i=0;i<curr.size();i++){
            
            int vertex=curr.get(i);
            if(!visited[vertex]){
                ans+=dfs(edges,visited,vertex,bananas);
            }
            
        }
        
        return ans;
        
    }
    
	public static long bfs(ArrayList<ArrayList<Integer>> edges, boolean[] visited, int sv, int[] bananas){
        
        Queue<Integer> q=new LinkedList<Integer>();
        
        q.add(sv);
        visited[sv]=true;
        long count=0;
        
        while(!q.isEmpty()){
            
            int v=q.remove();
            count+=(long)bananas[v];
            
            ArrayList<Integer> curr=edges.get(v);
            
            for(int i=0;i<curr.size();i++){
                int vertex=curr.get(i);
                if(!visited[vertex]){
                    visited[vertex]=true;
                    q.add(vertex);
                }
            }
            
        }
        
        return count;
        
    }
    
    
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                edges.add(new ArrayList<Integer>());
            }
            
            for(int i=0;i<m;i++){
                int sv=sc.nextInt();
                int ev=sc.nextInt();
                sv--;
                ev--;
                ArrayList<Integer> curr=edges.get(sv);
                curr.add(ev);
                curr=edges.get(ev);
                curr.add(sv);
            }
            
            int bananas[]=new int[n];
            
            for(int i=0;i<n;i++){
                bananas[i]=sc.nextInt();
                
            }
            
            boolean visited[]=new boolean[n];
            
            long max=0;
            
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    long temp=bfs(edges,visited,i,bananas);
                    if(temp>max){
                        max=temp;
                    }
                }
            }
            
            System.out.println(max);
            
            
        }

	}

}
