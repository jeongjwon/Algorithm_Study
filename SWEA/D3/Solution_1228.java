import java.util.*;

class Solution_1228 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 1;

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
           
            
            ArrayList<Integer> code = new ArrayList<>();

            for(int i = 0 ; i < n ; i++){
                code.add(sc.nextInt());
            }
            int order = sc.nextInt();
            for(int i = 0 ; i < order; i++){
                String str = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for(int j = 0 ; j < y ; j++){
                    code.add(x+j, sc.nextInt());
                }

            }
            System
                .out
                .println("#" + test_case + " " );
           for(int i = 0 ; i < 10 ; i++){
                System.out.print(code.get(i)+ " ");
            }
        }
        sc.close();
    }
}
