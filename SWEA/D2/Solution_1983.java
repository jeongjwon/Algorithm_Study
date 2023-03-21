

import java.util.*;


class Solution_1983
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

            int n = sc.nextInt();
            int k = sc.nextInt();
            
            double score = 0.0;
            Double[] rank = new Double[n];

            for(int i = 0 ; i < n ; i++){
                int mid = sc.nextInt();
                int fin = sc.nextInt();
                int asg = sc.nextInt();

                rank[i] = mid * 0.35 + fin * 0.45 + asg * 0.20;

                if(i+1 == k){
                    score = rank[i];
                }
                
            }

            Arrays.sort(rank, Collections.reverseOrder());
            int idx = 0;

            for(int i = 0 ; i < n ; i++){
                if(rank[i] == score){
                    idx = i;
                    break;
                }
            }

            
            int ans = idx / (n /10 );
            
			System.out.println("#"+ test_case + " "+grade[ans]);
		}
        sc.close();
	}
}

