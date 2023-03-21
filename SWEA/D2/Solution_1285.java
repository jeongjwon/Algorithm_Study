import java.util.*;

class Solution_1285
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;

            for(int i = 0 ; i < n; i++){
                arr[i] = sc.nextInt();
                min = Math.min(min, Math.abs(arr[i])); 
            }
            int cnt =0;
            
            for(int i = 0 ; i < n ; i++){
                if(Math.abs(arr[i]) == min) cnt++;
            }

            System.out.println("#"+test_case+" "+min + " "+cnt);


			
		}
        sc.close();
        
	}
}

