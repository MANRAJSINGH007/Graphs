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
    
    public static void dfsTranspose(ArrayList<ArrayList<Integer>> edgesT, int n, boolean[] visited, int sv, HashMap<Integer,Integer> map){
        
        visited[sv]=true;
        map.put(sv,1);
        ArrayList<Integer> curr=edgesT.get(sv);

        for(int i=0;i<curr.size();i++){
            int vertex=curr.get(i);
            if(!visited[vertex]){
                dfsTranspose(edgesT,n,visited,vertex,map);
            }
        }
        
        return ;
        
    }


	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        
        while(true){
            
            int n=sc.nextInt();
            if(n==0){
                break;
            }
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

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(edges,n,visited,i,stack);
                }
            }
            
            visited=new boolean[n];
            
            ArrayList<HashMap<Integer,Integer>> root=new ArrayList<>();
            
            while(stack.size()>0){
                
                int vertex=stack.pop();
                
                if(!visited[vertex]){
                    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                    root.add(map);
                    dfsTranspose(edgesT,n,visited,vertex,map);
                }
                
            }
            
            ArrayList<Integer> answer=new ArrayList<Integer>();
            
            for(int i=0;i<root.size();i++){
                HashMap<Integer,Integer> map=root.get(i);
                Set<Integer> keys=map.keySet();
                int flag=0;
                l:for(Integer vertex : keys){
                    ArrayList<Integer> curr=edges.get(vertex);
                    for(int d=0;d<curr.size();d++){
                        if(!map.containsKey(curr.get(d))){
                            flag=1;
                            break l;
                        }
                    }
                }
                
                if(flag==0){
                    for(Integer vertex : keys){
                        answer.add(vertex);
                    }
                }
            }
            
            if(answer.size()>0)
                Collections.sort(answer);
            for(int i=0;i<answer.size();i++){
                System.out.print(answer.get(i)+1+" ");
            }
            
           
            System.out.println();
            
            
        }

	}

}
