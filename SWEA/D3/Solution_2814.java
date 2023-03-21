import java.util.*;

class Solution_2814 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] dis;
    static int answer ;
    public static void dfs(int start, int cost){
        
        visited[start] = true;
        ArrayList<Integer> to = graph.get(start);
        //인접한 정점 리스트

        for(int next : to){
            if(!visited[next]){
                dfs(next, cost+1);
                visited[next] = false;
            }
        }
        visited[start]= false;
        
        answer = Math.max(answer, cost);
            
        
        


        

    }

    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

          
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            // int[][] graph = new int[n+1][n+1];
           
            graph = new ArrayList<>();
            for(int i =0 ; i < n+1 ; i++){
                graph.add(new ArrayList<Integer>());
            }
            for(int i = 0 ; i < m ; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
                // graph[x][y] = 1;
                // graph[y][x] = 1;
            }
            visited = new boolean[n+1];
            dis = new int[n+1];
            answer = 0;
            for(int i =1 ; i < n+1 ; i++){
                dfs(i, 1);
            }   
           
            
            
            
            

           
            
            System
                .out
                .println("#" + test_case + " " + answer );

        }
        sc.close();
    }
}
