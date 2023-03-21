import java.util.*;

class Solution_1206 {

    public static void main(String args[])throws Exception {

        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;
        

        for(int i = 1; i <= T ; i++){
            int n = sc.nextInt();
            int[] complex = new int[n];
            for(int j = 0 ; j < n ; j++){
                complex[j] = sc.nextInt();
            }
    
            int cnt= 0;
            
            for(int j= 2; j < n-2 ; j++){
                int left1 = complex[j-2];
                int left2 = complex[j-1];
                int right1 = complex[j+1];
                int right2 = complex[j+2];
                
                if(left1 < complex[j] &&  left2 < complex[j] &&
                    right1 < complex[j] && right2 < complex[j]){
                    int left = Math.min(complex[j]-left1, complex[j]-left2);
                    int right = Math.min(complex[j]-right1, complex[j]-right2);
                    cnt += Math.min(left, right);        
                }


            }
            System.out.println("#"+i + " "+cnt);
        }
        sc.close();
      
      
        
    }
}
