import java.util.*;
import java.io.*;

public class Baekjoon_13305_gasStation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dis = new int[n - 1];
        int[] prices = new int[n];
        // int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
            // total += dis[i];
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());

        }

        long price = 0;
        long min_price = prices[0];
        // 큰 자연수까지 이기 때문에 long 사용

        for (int i = 0; i < n - 1; i++) {
            // 마지막 도시의 가격은 필요 없음
            // 가격을 비교하면서 작은 가격을 가져감
            if (min_price > prices[i]) {
                min_price = prices[i];
            }
            price += min_price * dis[i];
        }
        System.out.print(price);

    }
}
