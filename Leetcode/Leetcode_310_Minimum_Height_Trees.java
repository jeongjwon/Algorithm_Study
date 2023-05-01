import java.util.*;

public class Leetcode_310_Minimum_Height_Trees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return new ArrayList<>(0);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());

        int[] degrees = new int[n];//연결된 간선개수

        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];
            graph.get(v).add(u);
            graph.get(u).add(v);
            degrees[v]++;
            degrees[u]++;
        }
        Queue<Integer> pq = new LinkedList<>();//리프노드만 추가
        for(int i = 0 ; i < n ; i++){
            if(degrees[i] == 1) pq.offer(i); //연결된 간선이 하나인 노드만 추가
        }
        for(int i = 0 ; i < n ; i++) System.out.print(degrees[i]+" ");

        System.out.println();
        System.out.println(pq);

        while(n > 2){
            //최소 높이 트리는 리프노드가 하나 또는 두 개인 트리
            int size = pq.size();
            n-=size;
            for(int i = 0 ; i <size ; i++){
                int poll  = pq.poll();
                System.out.println("현재 : "+poll);
               for(int next : graph.get(poll)){
                System.out.println("=> next : "+next);
                degrees[next]--;
                if(degrees[next]==1){
                    System.out.println("1이다!"+next);
                    pq.offer(next);
                }
               }
            }
        }
        List<Integer> answer = new ArrayList<>(pq);
     
 //0 => 3
 //1 => 3
 //2 => 3
 //3 => 0, 1, 2, 4
 //4 => 3, 5
 //5 => 4

        return answer;
    }
    public static void main(String[] args){
        // int n = 4;
        // int[][] edges = { {1,0}, {1,2}, {1,3} };
        int n = 6;
        int[][] edges = { {3,0}, {3,1}, {3,2}, {3,4}, {5,4} };
        List<Integer> result = findMinHeightTrees(n, edges);
        for(int r : result) System.out.println(r);
    }
}
