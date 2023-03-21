
import java.util.*;
import java.io.*;

public class Baekjoon_1759_makeCode {
    static int L, C;
    static String[] arr;
    static boolean[] visited;

    public static boolean isValid(String str) {
        int m = 0;
        int j = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                m++;
            } else
                j++;
        }

        if (m > 0 && j > 1)
            return true;
        return false;
    }

    public static void dfs(int start, int depth) {
        if (depth == L) {
            List<String> l = new ArrayList<>();
            String str = "";
            for (int i = 0; i < C; i++) {

                if (visited[i]) {
                    l.add(arr[i]);
                    str += arr[i];
                }

            }
            if (isValid(str)) {
                System.out.println(str);
            }

        }
        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        dfs(0, 0);

    }
}
