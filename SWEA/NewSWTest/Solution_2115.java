package NewSWTest;
import java.util.*;

class Solution_2115 {
    static int n, m, c, cost1, cost2;
    static int[][] beehome;
    static boolean[] checked; 

    static void check(int i, int j, int a, int b, int depth){

        System.out.println("check("+i+","+j+","+a+","+b+","+depth+")");

        if(depth == m){
            int count1 = 0, count2 = 0, c1 = 0, c2 = 0;
            for(int k = 0 ; k < m ; k++){
                if(checked[k]){
                    count1 += beehome[i][j+k];
                    c1 += (int)Math.pow(beehome[i][j+k], 2);
                    count2 += beehome[a][b+k];
                    c2 += (int)Math.pow(beehome[a][b+k],2);

                }
            }
            if(count1 <= c) cost1 = Math.max(cost1, c1);
            if(count2 <= c) cost2 = Math.max(cost2, c2);
            
            
        }

        checked[depth] = true;
        check(i,j,a,b,depth+1);
        checked[depth] = false;
        
       

    }
    static void makeProfit(){
    //두 일꾼의 각각 조합 만들기
    //가로로 연속 m개 조합 만들기 (단 조건은 c를 넘지 않는 것) -> list 저장 
        boolean[][] visited = new boolean[n][n];
        boolean flag;

         for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-m+1; j++){

                for(int k = j ; k < j + m ; k++){
                   
                    
                    visited[i][k] = true;

                }
                //일꾼1의 조합을 먼저 구해놓음

                for(int a = 0 ; a < n ; a++){
                    for(int b = 0 ; b < n - m + 1 ; b++){
                        flag = true;
                        for(int c = 0 ; c < m ; c++){
                            if(!visited[a][b+c]){

                                flag = false;
                                break;
                            }
                        }
                        if(flag) continue; //겹치지 않는다면 통과

                        
                        check(i,j,a,b,0);

                        
                       
                    }
                   


                }
                for(int k = j ; k < j + m ; k++){
                    visited[i][k] = false;
                }

            }
         }
    }

    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();

            beehome = new int[n][n];
            checked = new boolean[m];
            

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    beehome[i][j] = sc.nextInt();
                }
            }

            cost1 = 0;
            cost2 = 0;

            makeProfit();
          
            System
                .out
                .println("#" + test_case + " " );

        }
        sc.close();
    }
}



