import java.io.*;
import java.util.*;

public class Baekjoon_25304_receip {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int times = Integer.parseInt(st.nextToken());
            int value = price * times;
            X -= value;
        }
        if (X == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
