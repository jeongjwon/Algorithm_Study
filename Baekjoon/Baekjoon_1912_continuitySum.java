import java.util.*;
import java.io.*;

public class Baekjoon_1912_continuitySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 이전의 값 + 현재값 / 현재값
            max = Math.max(dp[i], max);
            // System.out.print(dp[i] + " ");

        }

        System.out.println(max);

        // 어렵게 생각할 필요 없다
    }
}
