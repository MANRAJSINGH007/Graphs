import java.util.*;

class Pair{
    
    int vertex;
    int ans;
    
    Pair(int vertex, int ans){
        this.vertex=vertex;
        this.ans=ans;
    }
    
}

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++){
            
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            ArrayList<HashSet<Integer>> edges=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                edges.add(new HashSet<Integer>());
            }
            
            for(int i=0;i<m;i++){
                int sv=sc.nextInt();
                int ev=sc.nextInt();
                sv--;
                ev--;
                HashSet<Integer> curr=edges.get(sv);
                curr.add(ev);
                curr=edges.get(ev);
                curr.add(sv);
            }
            
            Queue<Pair> q=new LinkedList<Pair>();
            
            boolean visited[]=new boolean[n];
            
            q.add(new Pair(0,0));
            visited[0]=true;
            
            l:while(!q.isEmpty()){
                
                Pair obj=q.remove();
                
                int v=obj.vertex;
                
                HashSet<Integer> set=edges.get(v);
                Iterator<Integer> it = set.iterator();
                while(it.hasNext()){
                    
                    int j=it.next();
                    if(!visited[j]){
                        
                        if(j==n-1){
                            System.out.println(obj.ans+1);
                            break l;
                        }
                        
                        q.add(new Pair(j,obj.ans+1));
                        visited[j]=true;
                    }
                    
                }    
                
            }
            
            
        }

	}

}
