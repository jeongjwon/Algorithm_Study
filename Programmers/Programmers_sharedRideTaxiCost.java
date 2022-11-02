import java.util.*;

class Edge implements Comparable<Edge>{
    int v;
    int cost ;
    public Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
    
}
class  Programmers_sharedRideTaxiCost {
    
    static ArrayList<ArrayList<Edge>> graph;
    static final int MAX = 20000001;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;

        graph = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());

        }
        for(int[] fare : fares){
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
       
        
//         for(int i = 0 ; i < graph.size() ; i++){
//             System.out.print(i + " =>  ");
//             for(int j = 0 ; j < graph.get(i).size() ; j++){
//                 System.out.print("( "+graph.get(i).get(j).v + " , " + graph.get(i).get(j).cost + " ) ,");
//             }
//             System.out.println();
//         }

        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];

        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        
        for(int i = 1; i <= n ; i++){
//             int sum = startA[i] + startB[i]+start[i];
//             System.out.println(startA[i]+ "  "+startB[i] + "  "+ start[i]+ "  "+ sum); ;
            answer = Math.min(answer, startA[i]+startB[i]+start[i]);
        }
        return answer;
    }
    public static int[] dijkstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int curV = now.v;
            int curCost = now.cost;

            if(curCost > costs[curV]) continue;

            //연결된 노드 확인
            ArrayList<Edge> edges = graph.get(curV);
            for(Edge e: edges){
                int cost = costs[curV] + e.cost;

                if(cost < costs[e.v]){
                    //현재 직통으로 연결된 가중치보다 이어 간 가중치가 더 작을 때 갱신
                    costs[e.v] = cost;
                    pq.offer(new Edge(e.v, cost));
                }
            }
        }
        return costs;
    }
    public static void main(String[] args) {

        int n = 6;
        int s = 4; // 출발지점
        int a = 6; // a의 도착지점
        int b = 2; // b의 도착지점
        int[][] fares = {
            {4,1,10},
            {3,5,24},
            {5,6,2},
            {3,1,41},
            {5,1,24},
            {4,6,50},
            {2,4,66},
            {2,3,22},
            {1,6,25}
        };

        System.out.println(solution(n,s,a,b,fares));
    }
}
