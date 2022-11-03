import java.util.*;
class Road{
    int x, y, dir, cost;
    public Road(int x, int y, int dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
public class Programmers_trackConstruction {
   static boolean[][] visited;
   static int[] dx = {0,0,-1,1};
   static int[] dy = {1,-1,0,0};
   static int min = Integer.MAX_VALUE;
    public static void dfs(int[][] board) {
        
        int n = board.length;
        visited = new boolean[n][n];

        Queue<Road> queue=new LinkedList<>();

        queue.add(new Road( 0,0,-1,0 ));


        visited[0][0] = true;

        while (!queue.isEmpty()) {

            Road r = queue.poll();

            if (r.x == n - 1 && r.y == n - 1) {
                // 끝 부분 도착하면
                min = Math.min(min, r.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = r.x + dx[i];
                int ny = r.y + dy[i];
                int nDir = i;
                int nCost = r.cost;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }

                // 방향 체크
                if (r.dir == -1 || r.dir == nDir) {
                    // 직선이거나 지나온 방향이 지금과 같을 때
                    nCost += 100;
                } else {
                    // 그 외는 코너 = 직선 + 코너
                    nCost += 600;
                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    board[nx][ny] = nCost;
                    queue.add(new Road(nx,ny,nDir, nCost));
                }else{
                    if(board[nx][ny] >= nCost){
                        board[nx][ny] = nCost;
                        queue.add(new Road(nx,ny,nDir,nCost));
                    }
                }
            }
        }
    }

    public static int solution(int[][] board) {
        
        dfs(board);

        return min;

    }

    public static void main(String[] args) {
        // int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        // int[][] board = {
        //         { 0, 0, 0, 0, 0, 0, 0, 1 },
        //         { 0, 0, 0, 0, 0, 0, 0, 0 },
        //         { 0, 0, 0, 0, 0, 1, 0, 0 },
        //         { 0, 0, 0, 0, 1, 0, 0, 0 },
        //         { 0, 0, 0, 1, 0, 0, 0, 1 },
        //         { 0, 0, 1, 0, 0, 0, 1, 0 },
        //         { 0, 1, 0, 0, 0, 1, 0, 0 },
        //         { 1, 0, 0, 0, 0, 0, 0, 0 }
        // };

        int[][] board = {
        { 0, 0, 1, 0 },
        { 0, 0, 0, 0 },
        { 0, 1, 0, 1 },
        { 1, 0, 0, 0 }
        };

        System.out.println(solution(board));
    }

}

