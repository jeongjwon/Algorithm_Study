import java.util.*;
import java.io.*;

public class Baekjoon_1920_findNumber {
    static int N, M, num;
    static int[] arr, B;

    static int find(int number) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println("mid : " + mid);
            if (number < arr[mid]) {
                right = mid - 1;
            } else if (number > arr[mid]) {
                left = mid + 1;
            } else {
                return 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sb.append(find(B[i])).append("\n");
            // System.out.println(find(B[i]));

        }
        System.out.print(sb);
    }
}
