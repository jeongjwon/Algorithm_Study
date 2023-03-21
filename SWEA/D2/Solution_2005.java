
import java.util.*;



class Solution_2005
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] dp = new int[n][n];
            // Arrays.fill(dp,1);
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j <= i ; j++){
                    if(j == 0 || j == i) dp[i][j] = 1;
                    else {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                
                    }
                    
                }
                
            }
           

            System.out.println("#"+test_case);
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j <= i ; j++){
                    System.out.print(dp[i][j]+ " ");
                }
                System.out.println();
            }
            
		}
        sc.close();
	}
}