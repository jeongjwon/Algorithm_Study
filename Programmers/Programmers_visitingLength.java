import java.util.*;

public class Programmers_visitingLength {
    static char[] c = { 'U', 'D', 'R', 'L' };
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static boolean[][][] visited = new boolean[11][11][4];

    public static int solution(String dirs) {
        int answer = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            hm.put(c[i], i);
        }

        Queue<int[]> queue = new LinkedList<>();

        int cx = 5;
        int cy = 5;
        for (int i = 0; i < dirs.length(); i++) {

            int idx = hm.get(dirs.charAt(i));
            int reverse = (idx % 2 == 0) ? ((idx == 0) ? 1 : 3) : ((idx == 1 ? 0 : 2));
            int nx = cx + dx[idx];
            int ny = cy + dy[idx];

            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                continue;
            }
            if (!visited[nx][ny][idx]) {
                answer++;

                visited[nx][ny][idx] = true;//갈 방향

                visited[cx][cy][reverse] = true;//온 방향

            }
            cx = nx;
            cy = ny;
            // queue.add(new int[] { nx, ny, idx });

        }

        return answer;
    }

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
}
