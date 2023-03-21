
import java.util.*;
import java.io.*;

public class Baekjoon_1806_prefixSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;

        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (e <= N && s <= N) {
            System.out.println("s : " + s + " e : " + e + " sum : " + sum);
            if (sum < S) {
                sum += A[e++];
            } else if (sum >= S) {
                sum -= A[s++];
                len = Math.min((e - s + 1), len);

            }
        }

        // if (len == Integer.MAX_VALUE) {
        // System.out.println('0');
        // } else {
        // System.out.println(len);
        // }
        System.out.println(len == Integer.MAX_VALUE ? "0" : len);

    }
}
