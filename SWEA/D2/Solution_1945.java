
import java.util.*;

class Solution_1945
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        int[] factor = { 2,3,5,7,11 };
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[] res = new int[factor.length];

            int idx = 0;
            
                while(idx < factor.length){
                    if(n % factor[idx] == 0) {
                        res[idx]++;
                        n /= factor[idx];
                    }
                    else{
                        idx++;
                    }

                }
            
        
            System.out.print("#"+test_case+ " " );
            for(int r : res) System.out.print(r + " ");
            System.out.println();

			
		}
        sc.close();
	}
}

