import java.util.*;
import java.io.*;

public class Baekjoon_2470_TwoLiquid {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        long[] res = new long[2];

        long min = Integer.MAX_VALUE;

        while (start < end) {

            long sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                res[0] = arr[start];
                res[1] = arr[end];
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }

        }
        System.out.println(res[0] + " " + res[1]);

    }
}
