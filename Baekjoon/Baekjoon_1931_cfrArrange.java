import java.util.*;
import java.io.*;

public class Baekjoon_1931_cfrArrange {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (o1, o2) -> {
            // 끝나는 시간을 기준으로 오름차순 정렬
            if (o1[1] == o2[1])
                // 만약 같을 경우에는 시작 시작을 기준으로 오름차순 정렬
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        for (int i = 0; i < n; i++) {
            System.out.println(times[i][0] + " " + times[i][1]);
        }

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (times[i][0] >= end) {
                end = times[i][1];
                cnt++;
                System.out.println(times[i][0] + " " + times[i][1]);
            }
        }
        // 시간 초과
        // int[] room = new int[n];
        // for (int i = 0; i < n; i++) {
        // room[i] = 1;
        // for (int j = 0; j < i; j++) {

        // if (times[i][0] >= times[j][1]) {
        // room[i] = Math.max(room[i], room[j] + 1);
        // }

        // }
        // // System.out.println(times[i][0] + " " + times[i][1] + " = " + room[i]);
        // max = Math.max(max, room[i]);
        // }
        System.out.println(cnt);

    }
}
