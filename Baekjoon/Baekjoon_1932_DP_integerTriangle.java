import java.util.*;
import java.io.*;

public class Baekjoon_1932_DP_integerTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        // 상향식
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                arr[i - 1][j - 1] = Math.max(arr[i][j - 1], arr[i][j]) + arr[i - 1][j - 1];
            }
        }
        System.out.println(arr[0][0]);

        // 하향식

        // arr[0][0] = Integer.parseInt(st.nextToken());
        // int max = Integer.MIN_VALUE;
        // for (int i = 1; i < n; i++) {
        // st = new StringTokenizer(br.readLine());
        // for (int j = 0; j <= i; j++) {
        // if (j == 0) {
        // arr[i][j] = arr[i - 1][j] + Integer.parseInt(st.nextToken());
        // } else if (j == i) {
        // arr[i][j] = arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
        // } else {
        // arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) +
        // Integer.parseInt(st.nextToken());
        // }
        // max = Math.max(max, arr[i][j]);
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(max);
    }

}
