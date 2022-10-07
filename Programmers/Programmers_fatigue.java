import java.util.*;

class Programmers_fatigue {
    static int answer = 0, n;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {

        // 피로도 시스템 -> 일정피로도(최소필요 피로도 , 소모피로도) Arrays.sort(dungeons, (o1, o2) -> { return
        // o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]; });
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k, dungeons, 0, visited);

        return answer;
    }

    public static void dfs(int k, int[][] dungeons, int depth, boolean[] visited) {
        answer = Math.max(answer, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {
                {
                        80,
                        20
                },
                {
                        50,
                        40
                },
                {
                        30,
                        10
                }
        };
        System.out
                .println(solution(k, dungeons));
    }
}
