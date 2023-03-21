
import java.util.*;
import java.io.*;

public class Baekjoon_2559_permutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        // int[] sum = new int[n + 1]; -> 필요없어

        // 1. prefix
        // st = new StringTokenizer(br.readLine());

        // int max = Integer.MIN_VALUE;
        // for (int i = 1; i <= n; i++) {
        // arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        // } // 기존의 arr[0] = 0

        // for (int i = k; i <= n; i++) {
        // int value = arr[i] - arr[i - k];
        // max = Math.max(max, value);
        // }
        // System.out.println(max);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. sliding window

        // 3. two pointer
        int start = 1;
        int end = start + 1;

        while (end >= start + k - 1) {

        }

    }
}
