import java.util.*;

public class Main {
    
    public static void dfs(ArrayList<ArrayList<Integer>> edges, int n, boolean[] visited, ArrayList<Integer> component, int sv){
        
        visited[sv]=true;
        component.add(sv);
        
        ArrayList<Integer> curr=edges.get(sv);
        
        for(int i=0;i<curr.size();i++){
            int vertex=curr.get(i);
            if(!visited[vertex]){
                dfs(edges,n,visited,component,vertex);
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
            
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            int brr[]=new int[n];
            for(int i=0;i<n;i++){
                brr[i]=sc.nextInt();
            }
            
            ArrayList<ArrayList<Integer>> output=new ArrayList<>();
            
            ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                edges.add(new ArrayList<Integer>());
            }
            
            for(int i=0;i<m;i++){
                int sv=sc.nextInt();
                int ev=sc.nextInt();
                sv--;
                ev--;
                ArrayList<Integer> cur1=edges.get(sv);
                cur1.add(ev);
                ArrayList<Integer> cur2=edges.get(ev);
                cur2.add(sv);
            }
            
            boolean visited[]=new boolean[n];
            
            // ArrayList<ArrayList<Integer>> output=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    ArrayList<Integer> component=new ArrayList<Integer>();
                    dfs(edges,n,visited,component,i);
                    output.add(component);
                }
            }
            
            int s=output.size();
            int flag=0;
            
            l:for(int i=0;i<s;i++){
                
                HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                ArrayList<Integer> component=output.get(i);
                for(int j=0;j<component.size();j++){
                    map.put(arr[component.get(j)],1);
                }
                
                for(int j=0;j<component.size();j++){
                    int index=component.get(j);
                    
                    if(map.containsKey(brr[index])){
                        map.remove(brr[index]);
                    }
                    
                    else{
                        flag=1;
                        System.out.println("NO");
                        break l;
                    }   
                       
                }       
                       
                
            }
                       
            if(flag==0){
                System.out.println("YES");
            }           
            
            
        }
        
        

	}

}
