
import java.util.*;
import java.io.*;

public class Baekjoon_11066_combineFile {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

            }
            combine(arr);

        }
    }

    public static void combine(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        int[] sum = new int[len];

        // 합계
        sum[0] = arr[0];
        for (int i = 1; i < len; i++)
            sum[i] = sum[i - 1] + arr[i];

        for (int i = 0; i < arr.length - 1; i++) {
            dp[i][i + 1] = arr[i] + arr[i + 1];

            System.out.print(dp[i][i + 1] + " ");
        }

        for (int gap = 2; gap < len; gap++) {

        }
    }
}
