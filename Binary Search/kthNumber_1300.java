import java.util.*;
import java.io.*;

public class Baekjoon_kthNumber_1300 {
    static long N, k;
    static long[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long min = 1;
        long max = k;

        while (min <= max) {
            long mid = (min + max) / 2;

            long cnt = 0;
            // 타임에러 (O^n2)
            // for (int i = 1; i <= N; i++) {
            // for (int j = 1; j <= N; j++) {
            // if (mid > i * j) {
            // cnt++;
            // }
            // }
            // }

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
                // 하나하나 비교할 필요없이 행별로 작거나 같은 수의 개수를 구함
                // 하지만 N을 초과하지 않게 하기 위해 min을 사용한다.

            }
            if (cnt < k) {
                min = mid + 1;

            } else {
                max = mid - 1;
            }

            System.out.println("mid : " + mid + " cnt : " + cnt + " min : " + min + " max: " + max);
        }
        System.out.print(min);
    }
}
