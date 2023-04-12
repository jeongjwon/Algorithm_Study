import java.util.*;
public class Leetcode_200_Number_of_islands {
    //상 하 좌 우
    public static int[] dx = {-1, 1, 0 ,0};
    public static int[] dy = {0, 0, -1, 1};
    public static void bfs(char[][] grid, boolean[][] visited, int x, int y){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            System.out.println("("+cur[0]+","+cur[1]+")");
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                if(grid[nx][ny] == '1' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
    public static void dfs(char[][] grid, boolean[][] visited , int x, int y){
        System.out.println("("+x+","+y+")");
        visited[x][y] = true;

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            if(grid[nx][ny] == '1' && !visited[nx][ny]){
                dfs(grid, visited, nx, ny);
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int island = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    // bfs(grid, visited, i,j);
                    dfs(grid, visited, i,j);
                    island++;
                }
            }
        }
        return island;
    }
    public static void main(String[] args){
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '1', '0'},
            {'0', '0', '0', '0', '1'}
        };
        System.out.println(numIslands(grid));
    }
}
//Breadth-First-Search