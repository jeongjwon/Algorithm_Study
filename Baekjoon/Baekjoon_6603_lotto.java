
import java.util.*;
import java.io.*;

public class Baekjoon_6603_lotto {
    static int[] s;
    static boolean[] visited;
    static int[] arr = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start, int depth) {

        if (depth == 6) {
            for (int i = 0; i < s.length; i++) {
                if (visited[i])
                    System.out.print(s[i] + " ");
            }
            System.out.println();

        }

        for (int i = start; i < s.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            s = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            // for (int i = 0; i < s.length; i++) {
            // System.out.print(s[i] + " ");
            // }
            dfs(0, 0);
            System.out.println();
        }

    }
}
