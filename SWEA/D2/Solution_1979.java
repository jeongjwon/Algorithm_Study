
import java.util.*;


class Solution_1979
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][n];

            int ans = 0;
            for(int i = 0 ; i < n ; i++){
                int cnt = 0;
                List<Integer> len = new ArrayList<>();
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j] == 1){
                        cnt++;
                    }else {
                        if(cnt > 0){
                            len.add(cnt);
                            cnt = 0;
                        }                        
                    }
                }
                len.add(cnt);
                if(!len.isEmpty()){
                    for(int l : len){
                        if(l == k){
                            ans++;
                        }
                    }
                }
            }

            for(int i = 0 ; i < n ; i++){
                int cnt = 0;
                List<Integer> len = new ArrayList<>();
                for(int j = 0 ; j < n ; j++){
                    if(arr[j][i] == 1){
                        cnt++;
                    }else {
                        if(cnt > 0){
                            len.add(cnt);
                            cnt = 0;
                        }                        
                    }
                }
                len.add(cnt);
                if(!len.isEmpty()){
                    for(int l : len){
                        if(l == k){
                            ans++;
                        }
                    }
                }
            }



			System.out.println("#"+ test_case + " "+ans);
		}
        sc.close();
	}
}

