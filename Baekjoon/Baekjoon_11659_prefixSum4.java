import java.util.*;
import java.io.*;

public class Baekjoon_11659_prefixSum4 {
    static int N, M;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sum = new int[N];

        st = new StringTokenizer(br.readLine());

        arr[0] = 0;

        for (int i = 1; i <= N; i++) {
            // arr[i] = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        // for (int i = 0; i < N - 1; i++) {
        // sum[i + 1] = sum[i] + arr[i];
        // }
        for (int s : arr)
            System.out.println(s);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(arr[end] - arr[start - 1]);
            // System.out.println(sum[end - 1] - sum[start - 1] + arr[end - 1]);
            // System.out.println(sum[i]);
        }

    }
}
