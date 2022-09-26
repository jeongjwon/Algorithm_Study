import java.util.*;
import java.io.*;

public class Baekjoon_3273_SumofTwoNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int cnt = 0;
        while (start < end) {

            // System.out.println("start : " + start + " end : " + end + " " + arr[start] +
            // " + " + arr[end] + " = "
            // + (arr[start] + arr[end]);

            if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] == x) {
                cnt++;
                start++;
            } else {
                start++;
            }

        }

        System.out.println(cnt);

    }
}
