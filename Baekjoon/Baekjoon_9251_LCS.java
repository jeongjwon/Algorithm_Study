
import java.io.*;

public class Baekjoon_9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        // LCS 길이 출력
        int max = 0;

        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {

                if (a[i] == b[j]) {

                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        System.out.println(max);

        // for (int i = 1; i <= A.length(); i++) {
        // for (int j = 1; j <= B.length(); j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        // LCS 출력
        StringBuilder sb = new StringBuilder();

        int i = dp.length - 1;
        int j = i;

        while (dp[i][j] != 0) {

            if (dp[i][j] == dp[i - 1][j]) {
                i = i - 1;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j = j - 1;
            } else {

                sb.append(a[i - 1]);
                i = i - 1;
                j = j - 1;
            }

        }
        String reverse = sb.reverse().toString();
        System.out.println(reverse);

    }
}
