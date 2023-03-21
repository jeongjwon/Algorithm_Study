import java.util.*;

class Solution_1217 {

    public static int rescure(int n, int m){
        
        if(m == 1){
            return  n;
        }else{
            
            return n * rescure(n,m-1);
        }
    }
  
    

    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {

            int order = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer = rescure(n,m);

            System
                .out
                .println("#" + test_case + " "+answer);

        }
        sc.close();
    }
}
