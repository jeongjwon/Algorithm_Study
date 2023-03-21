import java.util.*;

class Solution_1948
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] cal = {31,28,31,30,31,30,31,31,30,31,30,31};

            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();
            
            int diff = 0;
            
            for(int i = m1-1 ; i < m2-1 ; i++){
                diff += cal[i];
            }
            diff += d2-d1 + 1;
            
            System.out.println("#"+test_case+" "+diff);
			
		}
        sc.close();
	}
}

