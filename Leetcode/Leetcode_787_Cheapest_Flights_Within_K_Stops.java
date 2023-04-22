import java.util.*;


class Flight implements Comparable<Flight>{
// class Flight{
    int city;
    int price;
    int stop;

    Flight(int city, int price, int stop){
       this.city = city ;
       this.price = price;
       this.stop = stop ;
    }
    @Override
    public int compareTo(Flight other){
        return this.price - other.price;
    }
   
}
public class Leetcode_787_Cheapest_Flights_Within_K_Stops {
    // public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      
    //     List<List<Flight>> graph = new ArrayList<>();

    //     for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());

    //     for(int[] flight : flights){
    //         int from = flight[0];
    //         int to = flight[1];
    //         int price = flight[2];

    //         graph.get(from).add(new Flight(to,price,0));
    //     }
        
    //     int[] dist = new int[n];
    //     Arrays.fill(dist, Integer.MAX_VALUE);
    //     dist[src] = 0;

    //     // PriorityQueue<Flight> pq = new PriorityQueue<Flight>((a,b) -> {
    //     //         if(a.stop == b.stop){
    //     //             return a.price - b.price;
    //     //         }
    //     //         return a.stop - b.stop;
    //     //     }
    //     // );
    //     PriorityQueue<Flight> pq = new PriorityQueue<>();
    //     pq.offer(new Flight(src, 0,0));



    //     while(!pq.isEmpty()){
    //         Flight cur = pq.poll();

    //         int from = cur.city;
    //         int price = cur.price; //거쳐서 온 가격
    //         int stop = cur.stop;

    //         if(dst == from) return price;
    //         if(stop >  k) continue;
    //         for(Flight adj : graph.get(from)){
    //             int to = adj.city; // from을 거쳐서 to 까지 갈 가격
    //             int newPrice = price + adj.price; //거쳐서 온 가격 + to까지 갈 가격
                
    //             if(dist[to] > newPrice || dist[to] == Integer.MAX_VALUE){
    //                 dist[to] = newPrice;
    //                 pq.offer(new Flight(to, newPrice, stop+1));
    //             }
    //         }
    //     }

    //     return -1;
    // }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[] cost = new int[n]; // 각 도시까지의 최소 비용을 저장할 배열
        Arrays.fill(cost, Integer.MAX_VALUE); // 초기값은 무한대로 설정
        cost[src] = 0; // 출발 도시의 비용은 0

        for (int i = 0; i <= K; i++) { // 최대 비용 허용치 K까지 반복
            int[] temp = Arrays.copyOf(cost, n); 
            // 이전 단계의 비용을 저장할 임시 배열
            //Arrays.copyOf(original, newLength)  복사할 원본 배열 original 배열의 크기 newLength
            //newLength 가 원본 배열의 길이보다 작은 경우 지정된 길이까지 , 혹은 클 경우 뒷부분은 0 또는 null로

            // for(int j = 0 ; j < temp.length ; j++){
            //     System.out.print(temp[j] + " ");
            // }
            // System.out.println();

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                // System.out.println("from : "+from + "  to : "+to +"  price : "+price);
                if (cost[from] != Integer.MAX_VALUE) { // 출발 도시까지의 비용이 무한대가 아닌 경우에만 갱신 , 무한대인 경우는 아직 경우하지 않았음을 의미
                    temp[to] = Math.min(temp[to], cost[from] + price); // 이전 단계의 비용과 현재 비용을 비교하여 갱신
                    // System.out.println("cost["+from + "]가 무한대가 아님! => "+ "temp["+to+"] = "+temp[to]);
                }
            }
            cost = temp; // 현재 단계의 비용을 저장
            // System.out.println();
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst]; // 목적지의 비용이 무한대인 경우 -1 반환, 그렇지 않으면 목적지의 비용 반환
    }
    public static void main(String[] args){
        int n = 5;
        // int[][] flights = { {0,1,100}, {1,2,100}, {2,0,100}, {1,3,600} , {2,3,200}};
        // int src = 0;
        // int dst = 3;
        // int k = 1;
        // int[][] flights = { {0,1,100}, {1,2,100}, {0,2,100}};
        // int src = 0, dst = 2, k = 1;
        // int[][] flights = {{ 0,1,100}, {1,2,100}, {0,2,500}};
        // int src = 0, dst = 2, k = 0;
        int[][] flights = {{ 0,1,5}, {1,2,5}, {0,3,2}, {3,1,2}, {1,4,1}, {4,2,1}};
        int src = 0, dst = 2, k = 2;
        System.out.println(findCheapestPrice(n,flights, src, dst, k));
    }
}
