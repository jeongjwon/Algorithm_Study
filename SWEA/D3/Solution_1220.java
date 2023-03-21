import java.util.*;

class Solution_1220   {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {

            int len = sc.nextInt();

            int[][] table = new int[len][len];

            for(int i = 0 ; i < len ; i++){
                // String s = sc.next();
                for(int j = 0 ; j < len ; j++){
                    // table[i][j] = Integer.parseInt(s.charAt(j)+"");
                    table[i][j] = sc.nextInt();
                }
            }
            //1 N down  / 2 S up
            //down
            
            int count = 0;

            //세로줄씩 내려가면서 탐색
            for(int i = 0 ; i < len ; i++){
                int last = 0;
                for(int j = 0 ; j < len ; j++){
                    if(table[j][i] == 1){
                        //1일 경우
                        last = 1;
                        //내려가면서 탐색하기 때문에 last = 1 유지
                    }else if(table[j][i] == 2) {
                        //2 S일 경우
                        //내려가면서 탐색하기 때문에 올라오는 S일 경우 최근이 N(last == 1) 이라면 교착상태
                        if(last == 1){
                            count++;
                            // System.out.println((i+1)+"줄에서 last : "+ last + " 교착 상태  : "+ count);
                        }
                        last = 2;
                    }
                   
                }
               
                
            }
            
          
            System
                .out
                .println("#" + test_case + " " + count);

        }
        sc.close();
    }
}

// 1020101 
// 0200000
// 0010010
// 0000122
// 0000010
// 0021021
// 0012202

//3 2 -> 1  , 1 -> 
