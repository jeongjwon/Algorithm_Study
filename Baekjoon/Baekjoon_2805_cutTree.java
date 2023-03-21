import java.util.*;
import java.io.*;

public class Baekjoon_2805_cutTree {
    static int N;
    static long M, max = 0;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (arr[i] - mid) > 0 ? arr[i] - mid : 0;

            }

            // System.out.println("mid : " + mid + " cnt : " + cnt);
            if (cnt < M) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // System.out.println("right : " + right + " left : " + left);
        System.out.println(right);

    }
}
