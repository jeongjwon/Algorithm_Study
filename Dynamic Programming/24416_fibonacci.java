import java.util.*;
import java.io.*;

public class Baekjoon_24416_fibonacci {
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[] f;

    public static int fib(int n) {

        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        } else
            return (fib(n - 1) + fib(n - 2));
    }

    public static int fibonacci(int n) {
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        f = new int[n];
        // recuive
        fib(n);
        System.out.print(cnt1 + " ");
        // dp
        fibonacci(n);
        System.out.println(cnt2);

    }
}
