import java.util.*;
import java.io.*;

public class Baekjoon_2579_upstair {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 2];
        int[] arr = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {

            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];

            // System.out.print(dp[i] + " ");
        }
        System.out.print(dp[n] + " ");

    }
}
