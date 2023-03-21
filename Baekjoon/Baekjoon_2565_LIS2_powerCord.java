import java.util.*;
import java.io.*;

public class Baekjoon_2565_LIS2_powerCord {
    static int[][] A;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        dp = new Integer[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (o1, o2) -> {
            return o1[0] - o2[0];
        }); // 오름차순으로 정렬한 후 LIS

        int max = 0;

        // for (int i = 0; i < n; i++) {
        // dp[i] = 1;
        // for (int j = 0; j < i; j++) {
        // if (A[i][0] > A[j][0] && A[i][1] > A[j][1]) {
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // }

        // }
        // max = Math.max(max, dp[i]);
        // }

        for (int i = 0; i < n; i++) {
            max = Math.max(recur(n), max);
        }
        System.out.print(n - max);
        // for (int d : dp)
        // System.out.print(d + " ");

    }

    // 재귀
    public static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = 1;
            for (int i = n + 1; i < dp.length; i++) {
                if (A[n][1] < A[i][1]) {
                    dp[n] = Math.max(dp[n], recur(i) + 1);
                }
            }
        }
        return dp[n];

    }
}
