import java.util.*;

public class Programmers_jumpandTeleportation {
    public static int solution(int n) {
        // k칸 점프 , 현재 온 거리 * 2 순간이동
        // 건전지 사용량 : K , 0
        // 점프 최소화

        int ans = 0; // 건전지 사용량
        // 1 2 4
        // 1 2 3 6 12 24 48 50 100 200 400 600
        // 5000 / 2 = 2500 / 2 = 1250 / 2 = 625 - 1 = 624 / 2 = 312
        // 312 / 2 = 156 / 2 = 78 / 2 = 39 - 1 = 38 / 2 = 19 - 1 =18
        // 18 / 2 = 9 -1 =8 /2 =4 /2 = 2 -1 =0
        while (n > 2) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }
}
