import java.util.*;
import java.io.*;

public class Baekjoon_11054_LIS1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        int[] dp = new int[n];
        int[] r_dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            r_dp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }

        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] += r_dp[i];
            max = Math.max(dp[i], max);
        }

        System.out.println(max - 1);

    }
}
