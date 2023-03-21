import java.util.*;
import java.io.*;

public class Baekjoon_12865_backpack {
    static int[][] dp;
    static int[][] stuff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1]; // 개수 무게
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            w[i] = a;
            v[i] = b;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            // i th item
            for (int j = 1; j <= k; j++) {
                // k 무게

                // dp[i][j] = dp[i - 1][j];
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
                max = Math.max(max, dp[i][j]);
                // System.out.print(dp[i][j] + " ");
            }

            // System.out.println();

        }
        System.out.println(max);
    }

}
