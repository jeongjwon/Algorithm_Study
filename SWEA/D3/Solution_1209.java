
import java.util.*;

public class Solution_1209 {
    

    public static void main(String args[])throws Exception {

        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {

            int[][] arr = new int[100][100];

            int sumR = 0;
            int sumC = 0;
            int sumT = 0;
            int sumB = 0;

            for(int i = 0 ; i < 100 ; i++){
                for(int j = 0 ; j < 100 ; j++){
                    arr[i][j] = sc.nextInt();
                   
                }
            }
            
            for(int i = 0 ; i < 100 ; i++){
                int new_sumR = 0, new_sumC = 0; 
                for(int j = 0 ; j < 100 ; j++){
                    new_sumR += arr[i][j];
                    new_sumC += arr[j][i];
                    sumR = Math.max(sumR, new_sumR);
                    sumC = Math.max(sumC, new_sumC);
                 
                }
                sumT += arr[i][i];
                sumB += arr[i][99-i];

            }
            
            int max = Math.max(sumR , Math.max(sumC, Math.max(sumT, sumB)));
            System
                .out
                .println("#" + test_case + " " +max);

        }
        sc.close();
    }
}
