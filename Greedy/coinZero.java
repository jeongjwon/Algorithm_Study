import java.util.*;
import java.io.*;

public class Baekjoon_coin0_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= coins[i]) {

                cnt += k / coins[i];
                // System.out.println("k : " + k + " , coins[i] : " + coins[i] + " , cnt : " +
                // cnt);
                k %= coins[i];

            }
        }
        System.out.println(cnt);

    }
}
