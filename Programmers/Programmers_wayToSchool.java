import java.util.*;

public class Programmers_wayToSchool {
    static int[][] map;

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[m][n];

        map[0][0] = 1;
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if (i != 0) {
                    map[i][j] += map[i - 1][j] % 1000000007;
                }
                if (j != 0) {
                    map[i][j] += map[i][j - 1] % 1000000007;
                    
                }
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        answer = map[m - 1][n - 1] % 1000000007;
        return answer;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        System.out.println(solution(m, n, puddles));
    }
}
