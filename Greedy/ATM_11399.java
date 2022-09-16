import java.util.*;
import java.io.*;

public class Baekjoon_ATM_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] p = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i][0] = i;
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int[] wait = new int[n];
        wait[0] = p[0][1];
        int sum = wait[0];
        for (int i = 1; i < n; i++) {
            wait[i] = wait[i - 1] + p[i][1];
            sum += wait[i];
        }
        System.out.println(sum);
    }
}
