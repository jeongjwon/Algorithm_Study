import java.util.*;
import java.io.*;

public class Baekjoon_2110_routerInstallation {
    public static void main(String[] args) throws IOException {
        int N, C;
    long[] x;
    long max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, x[i]);
        }

        Arrays.sort(x);

        long left = 1;
        long right = max;

        // 가장 인접한 두 공유기 사이의 최대 거리

        while (left <= right) {
            long mid = (left + right) / 2; // mid = 가장 인접한 두 공유기 사이의 거리
            long cnt = 1;
            long temp = x[0];
            for (int i = 1; i < N; i++) {

                if (temp + mid <= x[i]) {
                    cnt++;
                    temp = x[i];
                }
                // 각 위치에 mid만큼의 거리들을 조율하면 위치를 이동시켜준다
            }
            if (cnt < C) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // System.out.println("mid : " + mid + " cnt : " + cnt + " left : " + left + " right: " + right);

        }
        System.out.println(right);
    }

}
