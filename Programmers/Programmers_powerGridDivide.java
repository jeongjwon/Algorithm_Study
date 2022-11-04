import java.util.*;

class Programmers_powerGridDivide {
    static ArrayList<ArrayList<Integer>> tree;
    static int[][] graph;
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        //구축
        graph = new int[n+1][n+1];
        tree = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0 ; i < wires.length ; i++){
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);

            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 0;

        }

        for(int i = 1 ; i <= n ; i++){
            System.out.print(i + " => ");
            for(int j = 0; j < tree.get(i).size() ; j++){
                System.out.print(tree.get(i).get(j) + " , ");
            }
            System.out.println();
        }

        for(int i = 0 ; i < wires.length ; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            //인접리스트
            int n1 = bfs2(n,a,b);
            int n2 = bfs2(n,b,a);
            // System.out.println("전력차 :" + Math.abs(n1-n2));
            answer = Math.min(answer, Math.abs(n1-n2));

            //인접 행렬
            // graph[a][b] = 0;
            // graph[b][a] = 0;

            // System.out.println("전력차 : "+bfs(n,a));
            // answer = Math.min(answer, bfs(n,a));

            // graph[a][b] = 1;
            // graph[b][a] = 1;
            
        }

        return answer;
    }
    public static int bfs(int n, int start){//인접행렬
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int cnt = 1;
        queue.add(start);

        while(!queue.isEmpty()){
            int poll = queue.poll();
           
            for(int i = 1 ; i <= n ; i++){
                if(visited[i]) continue;
                if(graph[poll][i] == 1){
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }

        return Math.abs(n - 2*cnt);
    }
    public static int bfs2(int n, int v1, int v2){//인접리스트
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        boolean[] visited = new boolean[n+1];
        visited[v1] = true;

        int cnt = 1;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            for(int next : tree.get(poll)){
                if(next != v2 && !visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        int n = 9;
        int[][] wires = { {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));
    }
}
