import java.util.*;

public class Main {
    
    public static void dfs(ArrayList<ArrayList<Integer>> edges, int n, boolean[] visited, int sv, Stack<Integer> stack){
        
        visited[sv]=true;
        
        ArrayList<Integer> curr=edges.get(sv);
        
        for(int i=0;i<curr.size();i++){
            int vertex=curr.get(i);
            if(!visited[vertex]){
                dfs(edges,n,visited,vertex,stack);
            }
        }
        
        stack.push(sv);
        
        return ;
        
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> edges, int n, boolean[] visited, int sv){
        
        visited[sv]=true;
        
        ArrayList<Integer> curr=edges.get(sv);

        for(int i=0;i<curr.size();i++){
            int vertex=curr.get(i);
            if(!visited[vertex]){
                dfs(edges,n,visited,vertex);
            }
        }
        
        return ;
        
    }


	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++){
            
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
            ArrayList<ArrayList<Integer>> edgesT=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                edges.add(new ArrayList<Integer>());
                edgesT.add(new ArrayList<Integer>());
            }
            
            for(int i=0;i<m;i++){
                int sv=sc.nextInt();
                int ev=sc.nextInt();
                sv--;
                ev--;
                ArrayList<Integer> cur1=edges.get(sv);
                cur1.add(ev);
                ArrayList<Integer> cur2=edgesT.get(ev);
                cur2.add(sv);
            }
            
            boolean visited[]=new boolean[n];
            
            Stack<Integer> stack=new Stack<Integer>();
            int cnt=0;
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    cnt++;
                    dfs(edges,n,visited,i,stack);
                }
            }
            
            visited=new boolean[n];
            
            int count=0;
            
            while(stack.size()>0){
                
                int vertex=stack.pop();
                
                if(!visited[vertex]){
                    count++;
                    dfs(edges,n,visited,vertex);
                }
                
            }
            
            System.out.println(count);
            
        }

	}

}
