

import java.util.Scanner;


class Solution_1986
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
            int res = 0;
            for(int i = 1 ; i <= n ; i++){
                if(i%2 == 0) res -= i;
                else res+=i;
            }
            System.out.println("#"+test_case + " " + res);
            
		}
		sc.close();
	}
}