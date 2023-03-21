import java.util.*;

class Solution_1289 {
   
    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

          String[] memory = sc.next().split("");
          String temp = "0";
        
          int cnt = 0;
          for(int i = 0 ; i < memory.length ; i++){
            if(!temp.equals(memory[i])){
                temp = memory[i];
                cnt++;
            }
          }
        
          
          
          System.out.println("#"+test_case + " "+cnt);
          

           
          
        }
        sc.close();
    }
}
