package NewSWTest;

import java.util.*;

public class Solution_2105 {
    static int n, oR, oC;
    static int[][] cafes;
    static boolean[] ate ;
    static int res ;
    //우하, 좌하, 좌상, 우상 : 시계방향 순서
    static int[] dx = { 1 , 1, -1, -1};
    static int[] dy = { 1 , -1, -1, 1 };

    static void dfs(int r, int c, int prevR, int prevC, int sum, int dir){
        //현재좌표 / 이전좌표 / 디저트 합 / 방향
        //이전좌표 -> visited 확인
        int newR, newC;


        for(int i = dir ; i < 4 ; i++){

            newR = r + dx[i];
            newC = c + dy[i];

            //범위 벗어날 경우
            if(newR < 0 || newC < 0 || newR >= n || newC >= n) continue;
            
            //이전의 좌표를 다시 온 경우
            if(newR == prevR && newC == prevC) continue;

            //시작점으로 도착한 경우
            if( (newR == oR) && (newC == oC)){
                res = Math.max(res, sum);
                return;
            }
           
            
            if(ate[cafes[newR][newC]]) continue;

            ate[cafes[newR][newC]] = true;
            dfs(newR, newC, r, c , sum+1, i);

            ate[cafes[newR][newC]] = false;

           
            
        }

        
    }


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = sc.nextInt();
            cafes = new int[n][n];

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    cafes[i][j] = sc.nextInt();
                }
            }
            
            res = -1;

            for(int i = 0 ; i < n - 2 ; i++){ 
                for(int j = 1 ; j < n - 1 ; j++){
                    ate = new boolean[101];
                    ate[cafes[i][j]] = true; 
                    
                    oR = i;
                    oC = j;

                    dfs(i ,j ,-1,-1 , 1, 0);
                }
            }
            
            System
                .out
                .println("#" + test_case + " " +res);

        }
        sc.close();
    }
}
