import java.util.*;
import java.io.*;

public class Baekjoon_1644_primeNumContinuitySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!prime[i])
                p.add(i);
        }
        System.out.println(p);

        int s = 0;
        int e = 0;
        int cnt = 0;
        int sum = 0;

        while (true) {
            if (sum >= N) {
                sum -= p.get(s++);

            } else if (e == p.size()) {
                break;
            } else {
                sum += p.get(e++);
            }

            if (N == sum)
                cnt++;
        }
        System.out.println(cnt);
    }
}
