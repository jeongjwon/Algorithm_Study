import java.util.*;

class Solution_2805 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            int[][] farm = new int[n][n];

            for(int i = 0 ; i < n ; i++){
                String str = sc.next();
                for(int j = 0 ; j < n ; j++){
                    farm[i][j] = Integer.parseInt(str.charAt(j)+"");
                }
            }
            
            int value = 0;

            for(int i = 0; i <= n/2 ; i++){
                for(int j = n/2 - i ; j <= n/2 + i ; j++){
                    
                    
                    if(i == n/2){
                        value += farm[i][j];
                    }else{
                        value += farm[i][j];
                        value += farm[n-i-1][j];
                    }
                    
                 
                }

            }
           
            
            
            
           
            System
                .out
                .println("#" + test_case + " "  + value);

        }
        sc.close();
    }
}
