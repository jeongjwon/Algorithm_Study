package NewSWTest;
import java.util.*;

class Solution_1952 {
    static int[] plan ;
    static int[] cost ;
    static int res ;

    public static void dfs(int month, int sum){
        if(res <= sum) return;

        if(month >= 12){
            res = Math.min(res, sum);
            return;
        }
        if(plan[month] == 0){
            dfs(month+1, sum);
        }else{
            //1일권
            dfs(month+1, sum + cost[0] * plan[month]);
            //1달권
            dfs(month+1, sum + cost[1] );
            //3달권
            dfs(month+3, sum + cost[2]);
        }
    }


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            cost = new int[4];
            for(int i = 0 ; i < cost.length ; i++){
                cost[i] = sc.nextInt();
                //1일권, 1달권, 3개월권, 1년권
            }
            

            plan = new int[13];

            for(int i = 1 ; i < plan.length ; i++){
                plan[i] = sc.nextInt();
              
            }

            // res = cost[3];// 기본적으로 1년권을 결과값으로 함

            // dfs(1,0);

            
            int[] dp = new int[13];
            
            //3월전까지는 1일권 vs 1달권
            dp[0] = 0;
            dp[1] = Math.min(plan[1] * cost[0] , cost[1]); 
            dp[2] = Math.min(dp[1] + plan[2] * cost[0] , dp[1] + cost[1]) ; 
            
            System.out.print(dp[0] + " " + dp[1] + " " + dp[2] + " ");

            for(int i = 3; i < plan.length ; i++){
                //3월부터는 1일권 vs 1달권 vs 3달권
                dp[i] = Math.min(dp[i-1] + plan[i] * cost[0] , Math.min(dp[i-1] + cost[1] , dp[i-3] + cost[2]));
                
                
            }
            res = Math.min(dp[12], cost[3]);
            
            // System.out.println("#" + test_case + " " +res);

            

        }
        sc.close();
    }
}







