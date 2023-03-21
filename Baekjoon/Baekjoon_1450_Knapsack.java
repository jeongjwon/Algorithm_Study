import java.util.*;
import java.io.*;

public class Baekjoon_1450_Knapsack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] stuff = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stuff[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N;

        while (true) {
            int m = (s + e) / 2;

        }

    }
}
