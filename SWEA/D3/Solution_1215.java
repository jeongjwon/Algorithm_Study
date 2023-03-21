
import java.util.*;

class Solution_1215 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int len = sc.nextInt();
            char[][] map = new char[8][8];
            for(int i = 0 ; i < 8 ; i++){
                String str = sc.next();
                for(int j = 0 ; j < 8 ; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            int cnt = 0 ;
            boolean flag = true;
            for(int i = 0 ; i < 8 ; i ++){
                for(int j = 0 ; j < 8 - len+1; j++){
                    flag = true;
                    for(int k = 0 ; k < len/2 ; k++){
                       
                        if(map[i][j+k] != map[i][len+j-1-k]){
                            flag = false;
                        }
                    }
                    if(!flag){
                        continue;
                    }else{
                        cnt++;
                    }
                   
                    
                }
                
            }
        
            for(int i = 0 ; i < 8 ; i ++){
                for(int j = 0 ; j < 8 - len+1; j++){
                    flag = true;
                    for(int k = 0 ; k < len/2 ; k++){
                        if(map[j+k][i] != map[len+j-1-k][i]){
                            flag = false;
                        }
                    }
                    if(!flag){
                        continue;
                    }else{
                        cnt++;
                    }
                    
                }
            }
            System
                .out
                .println("#" + test_case + " " + cnt );

        }
        sc.close();
    }
}
