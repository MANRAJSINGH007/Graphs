import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int dest=sc.nextInt();
        dest--;
        
        int path[]=new int[n-1];
        
        for(int i=0;i<n-1;i++){
            path[i]=sc.nextInt();
        }
        
        int source=0;
        
        while(source<dest){
            source=source+path[source];
        }
        
        if(source==dest){
            System.out.println("YES");
        }
        
        else{
            System.out.println("NO");
        }

	}

}
