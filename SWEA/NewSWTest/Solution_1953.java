package NewSWTest;

import java.util.*;

class Solution_1953 {
    
    // 상우하좌-> next step을 걸러내기 위함
    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };
    static String[] lo = { "상", "우", "하", "좌" };
    static String[] ts = { "", "상우하좌", "상하", "우좌", "상우", "우하", "하좌", "상좌" };
    static final int[][] type = {
            { 0, 0, 0, 0 },
            { 1, 1, 1, 1 }, // 1 -> 상 우 하 좌
            { 1, 0, 1, 0 }, // 2 -> 상 하
            { 0, 1, 0, 1 }, // 3 -> 우 좌
            { 1, 1, 0, 0 }, // 4 -> 상 우
            { 0, 1, 1, 0 }, // 5 -> 우 하
            { 0, 0, 1, 1 }, // 6 -> 하 좌
            { 1, 0, 0, 1 } };// 7 -> 상 좌

    static boolean[][] visited;
    static int n, m, r, c, l;
    static int answer ;
    static int[][] map;

    public static int bfs() {

        int hour = 0;
        int answer = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { r, c });
        visited[r][c] = true;

        
        
        while (!queue.isEmpty()) {
            if (hour == l-1)
                break;

            int size = queue.size();
            while (size-- > 0) {
                int[] prev = queue.poll();
                System.out.println("현재 : " + prev[0] + " , " + prev[1] + " " + ts[map[prev[0]][prev[1]]]);
                int[] dirs = type[map[prev[0]][prev[1]]];

                for (int i = 0; i < 4; i++) {
                    if (dirs[i] == 0)
                        continue; // 길이 없는 경우 pass
                    int curX = prev[0] + dx[i];
                    int curY = prev[1] + dy[i];
                    System.out.println(" 다음 : " + curX + " , "+ curY + " " + lo[i]);

                    if (curX < 0 || curY < 0 || curX >= n || curY >= m)
                        continue; // 길이 범위를 벗어난 경우 pass
                    if (map[curX][curY] == 0)
                        continue; // 길이 없는 경우 pass
                    if (visited[curX][curY])
                        continue; // 이미 방문한 경우 pass

                    if (type[map[curX][curY]][(i + 2) % 4] == 1) {// 존재할 경우
                        //상우하좌 
                        // 상 하 -> 반대
                        // 우 좌 -> 반대
                        // (i+2)%4 == 1 직전과 다음이 반대이라면 
                        visited[curX][curY] = true;
                        queue.add(new int[] { curX, curY });
                        ++answer;
                        System.out.println("시간 : " + hour + "   가능한 다음 : " + curX + " , " + curY + " " + lo[i]
                                + "   개수 : " + answer);

                    }
                    System.out.println();
                    //상우하좌
                    // 2 ,2  -> 2,3 우 3 / 3,2 하/ 2,1 좌
                            // 2,3 -> 2,4
                            // 3,2 -> 4,2
                            // 2,1 -> 2,0
                                    // 2,4 -> 2,5
                                    // 4,2 -> 4,3
                                    // 2,0 -> 1,0 / 3,0
                                            //2,5 -> 1,5 / 3,5
                                            //4,3
                                            //1,0
                                            //3,0
                }
            }
            ++hour;

            

        }
        return answer;

    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = sc.nextInt();
            m = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();

            l = sc.nextInt();

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            visited = new boolean[n][m];
            

            System.out
                    .println("#" + test_case + " " + bfs());

        }
        sc.close();
    }
}
