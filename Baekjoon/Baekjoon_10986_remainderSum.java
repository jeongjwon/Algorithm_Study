import java.util.*;
import java.io.*;

public class Baekjoon_10986_remainderSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i - 1] + arr[i];
        }

        // int start = 0;
        // int end = n - 1;
        // int cnt = 0;

        // for (int i = 1; i <= n; i++) {
        // if (sum[i] % m == 0)
        // cnt++;
        // }

    }
}
// 1 2 3 1 2
// 1 3 6 7 9 -> 3
// 2 5 6 8 -> 1
// 3 4 6 -> 2
// 1 3 -> 1
// 2 -> 0