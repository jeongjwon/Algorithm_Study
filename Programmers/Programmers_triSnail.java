import java.util.*;
public class Programmers_triSnail {
    public static int[] solution(int n) {
        
        int[][] dp = new int[n][n];
        //그냥 달팽이
        // int value = 1;
        // int f = 0;
        // while(value <= n*n){
        //     //top = n 개
        //     for(int j = f ; j < n- f; j++){
        //         dp[f][j] = value++;
        //     }

        //     //right = n-1개
        //     for(int j = f+1 ; j < n- f; j++){
        //         dp[j][n-f-1] = value++;
        //     }

        //     //bottom = n-1개
        //     for(int j = n-f-2 ; j >= f ; j--){
        //         dp[n-f-1][j] = value++;
        //     }
        //     //left = n-2개
        //     for(int j = n-f-2 ; j > f; j--){
        //         dp[j][f] = value++;
        //     }
        //     f++;
        // }

        
       
        int value = 1;
        int x = -1, y=0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                //하나씩 줄여감
                if(i % 3 == 0){
                    x++;
                }else if(i%3 == 1){
                    y++;
                }else {
                    x--;
                    y--;
                }
                
                dp[x][y] = value++;
            }
        }

        int[] answer = new int[value-1];
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i+1; j++){
                System.out.print(dp[i][j] + " ");
                answer[idx++] = dp[i][j];
            }
            System.out.println();
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        int[] res = solution(n);

        for(int r : res){
            System.out.print(r+" ");
        }
        //3 -> 6 + 0 = 3* 2
        //4 -> 10 = 9 + 1 = 4*2 + 1 + 1
        //5 -> 15 = 12 + 3 = 5*2 + 2 + 3 
        //6 -> 21 = 15 + 6 = 6*2 + 3 + 6

        //왼쪽 -> n개 / n-3개
        //아래쪽 -> n-1개 / n-4개
        //오른쪽 -> n-2개 /  n-5개
        
        //배열의 크기  = n * 2 + (n-3)
    }
    
}
