import java.util.*;
import java.io.*;

public class Baekjoon_1654_parametricSearch{
    static int K;
    static long N, max = 0;
    static long[] arr;

    static long parametricSearch(long[] arr) {

        long left = 1; // 0이 아니라 1을 사용
        long right = max; // 최대값

        while (left <= right) {
            long mid = (left + right) / 2;
            // 중간값을 계속 찾아가면서
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (arr[i] / mid);
            }

            // System.out.println("mid : " + mid + " cnt : " + cnt);
            // 중간값을 나눈값을 더한 랜선의 갯수가 N보다 작으면 늘려줘야하기 때문에 랜선의 길이를 짧게 한다.
            if (cnt < N) {
                right = mid - 1;
            } else { // 반대로 N보다 크다면 랜선의 길이를 크게 한다.
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(parametricSearch(arr));

    }
}
