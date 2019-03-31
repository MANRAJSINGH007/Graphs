import java.util.*;

public class Main{
    
    public static int func(int n, int[][] edges, int curr, HashMap<Integer,Integer> map){
        
        if(curr==n){
            return 1;
        }
        
        Set<Integer> keys=map.keySet();
        int flag=0;
        
        for(Integer j : keys){
            
            if(edges[j][curr]==1){
                flag=1;
                break;
            }
            
        }
        
        int m1=func(n,edges,curr+1,map);
        int m2=0;
        
        if(flag!=1){
            map.put(curr,1);
            m2=func(n,edges,curr+1,map);
            map.remove(curr);
        }
        
        return m1+m2;
        
        
    }
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int edges[][]=new int[n][n];
        
        for(int i=0;i<m;i++){
            int sv=sc.nextInt();
            int ev=sc.nextInt();
            sv--;
            ev--;
            edges[sv][ev]=1;
            edges[ev][sv]=1;
            
        }
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        System.out.println(func(n,edges,0,map));
        
    }
    
}
