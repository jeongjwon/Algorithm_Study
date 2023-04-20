import java.util.*;
class Node{
    int v, w;
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
public class Leetcode_743_Network_Delay_Time {
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < times.length ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph.get(u).add(new Node(v,w));
        }
        for(int i = 0 ; i <= n ; i++){
            System.out.print("노드 "+i+ ": ");
            List<Node> adj = graph.get(i);
            for(int j = 0 ; j < adj.size() ; j++){
                System.out.print("["+ adj.get(j).v + ", " + adj.get(j).w + "] ");
            }
            
            System.out.println();
        }
        //k 에서 모든 노드로 방문할 때의 최소의 cost 의 합
        // 다만, 어떤 노드에 가지 못한다면 -1
        
        //방문 여부 체크
        boolean[] visited = new boolean[n+1];

        //최단 거리 ( k에서 다른 노드들까지 )
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // 출발노드는 자기 자신이기 때문에 0

        //우선순위큐로 cost 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.offer(new Node(k,0));
        

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            //여기서는 출발지와 이전~출발지까지의 거리
            int from = cur.v;
            int time = cur.w;
            System.out.println("현재 " + from);

            //인접노드로 갈 수 있는 도착지와 가중치 확인
            for(Node adj : graph.get(from)){
                //from ~ to : cost
               int to = adj.v;
               int cost = adj.w;

               if(dist[to] > time + cost){
                
                int newDistace = time + cost;
                dist[to] = time + cost;
                System.out.println("아직 방문하지 않은 노드 " + to + "까지 새로운 거리 " + newDistace);
                pq.offer(new Node(to, newDistace));
               }
            }

        }

        for(int d : dist) System.out.print(d+ " ");

        int minimum = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            if(i == k) continue;
            if(dist[i] == Integer.MAX_VALUE){
                minimum = -1;
                break;
            }
            
            minimum = Math.min(minimum, dist[i]);
        }
        return minimum;

    }
    public static void main(String[] args){
        int[][] times = { {2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4;
        int k = 2;
        // int[][] times = { {1,2,1}, {2,3,2} };
        // int n = 3;
        // int k = 1;
        System.out.println(networkDelayTime(times, n, k));
    }
}
