import java.util.*;
import java.io.*;

public class Baekjoon_12015_theMostLongestIncreasingSeq2 {

    static long min, max = 0, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        ArrayList<Integer> list = new ArrayList<>(); // list 사용
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // dp - > 시간 초과
        // int[] dp = new int[N];
        // Arrays.fill(dp, 1);
        // long answer = 0;
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < i; j++) {
        // if (A[i] > A[j]) {
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // answer = Math.max(dp[i], answer);
        // }
        // }

        // }
        // System.out.println(answer);


        for (int i = 0; i < N; i++) {
            if (list.get(list.size() - 1) < A[i]) {
                // list 안의 마지막 값과 배열 값 비교 시 오름차순이라면 추가
                list.add(A[i]);
            } else {
                //추가할 위치를 mid로 하여 이분탐색
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < A[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, A[i]);

            }

        }
        System.out.println(list.size() - 1);

    }
}
