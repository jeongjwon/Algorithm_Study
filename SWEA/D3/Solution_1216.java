import java.util.*;

class Solution_1216 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 1;
        int n;
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            char[][] map = new char[100][100];
            for(int i = 0 ; i < 100 ; i++){
                String str = sc.next();
                for(int j = 0 ; j < 100 ; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            int ans = 0;
            boolean flag = true;

            //길이 l 을 지정해줌
            for(int l = 0 ; l <= 100 ; l++){ 
                for(int i = 0 ; i < 100 ; i ++){
                    for(int j = 0 ; j < 101 - l; j++){
                        flag = true;
                        for(int k = 0 ; k < l/2 ; k++){
                           
                            if(map[i][j+k] != map[i][l+j-1-k]){
                                flag = false;
                            }
                        }
                        if(!flag){
                            continue;
                        }else{
                            ans = Math.max(ans, l);
                        }
                       
                        
                    }
                    
                }
            }
           
            for(int l = 0 ; l <= 100 ; l++){
                for(int i = 0 ; i < 100 ; i ++){
                    for(int j = 0 ; j < 101 - l; j++){
                        flag = true;
                        for(int k = 0 ; k < l/2 ; k++){
                            if(map[j+k][i] != map[l+j-1-k][i]){
                                flag = false;
                            }
                        }
                        if(!flag){
                            continue;
                        }else{
                            ans = Math.max(ans, l);
                        }
                        
                    }
                }
            }
            
            System
                .out
                .println("#" + test_case + " " + ans );

        }
        sc.close();
    }
}
