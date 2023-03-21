
import java.io.*;
import java.util.*;

public class Baekjoon_15652_NandM {
    static boolean[] visited;
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1, i);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        dfs(0, 0);
        System.out.println(sb);

    }
}
