import java.util.*;

public class Programmers_delivery {
    static final int INF = 500001;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N][N];// 인접행렬

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                } else {
                    graph[i][j] = 500001;
                }
            }
        }

        for (int[] data : road) {
            if (graph[data[0] - 1][data[1] - 1] > data[2]) {

                graph[data[0] - 1][data[1] - 1] = data[2];
                graph[data[1] - 1][data[0] - 1] = data[2];
            }

        }

        // 플로이드 야샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (graph[0][i] <= K)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 6;
        // int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3,
        // 1 }, { 5, 4, 2 } };
        int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5,
                2 }, { 3, 5, 3 }, { 5, 6, 1 } };
        int K = 4;
        System.out.println(solution(N, road, K));

    }
}
