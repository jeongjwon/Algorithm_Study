import java.util.*;
import java.io.*;

public class Baekjoon_numberCard2_10816 {
    static int N, M;
    static int[] A;
    // static HashMap<Integer, Integer> hm;

    static int lowerBound(int number) {
        int left = 0;
        int right = N;

        while (left < right) {
            // int mid = left + ((right - left) / 2);
            int mid = (left + right) / 2;
            if (number <= A[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // System.out.println(left + " = ");
        return left;
    }

    static int uppderBound(int number) {
        int left = 0;
        int right = N;

        while (left < right) {
            // int mid = left + ((right - left) / 2);
            int mid = (left + right) / 2;
            if (number < A[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // System.out.print(left + " - ");
        return left;
    }
    // static int bound(int number) {
    // int left = 0;
    // int right = N - 1;

    // while (left <= right) {
    // int mid = (left + right) / 2;

    // if (number < A[mid]) {
    // right = mid - 1;
    // } else if (number > A[mid]) {
    // left = mid + 1;
    // } else {

    // return hm.get(number);
    // }
    // }
    // return 0;
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        // hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            // B[i] = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            sb.append(uppderBound(key) - lowerBound(key)).append(" ");
            // sb.append(find(B[i])).append(' ');
            // sb.append(uppderBound(B[i]) - lowerBound(B[i])).append(' ');
        }

        System.out.print(sb);
    }
}
