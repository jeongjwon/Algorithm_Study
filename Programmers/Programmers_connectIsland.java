
import java.util.*;

public class Programmers_connectIsland {

    static int[] parent;
    // minimum spanning tree, kruskal + union
    // 크루스칼 : 음수 가중치가 없는 무방향 그래프에서 최소 신장 트리를 찾는 알고리즘
    // 사이클이 발생하는 유무에 대해서는 union을 사용하여 부모가 같은지(같은 그래프에 속하는 유무 판별) 판별

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 건설 비용을 기준으로 오름차순으로 정렬 -> 출발 노선을 정할 수 있음
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);

        for (int[] graph : costs) {
            int start = graph[0];
            int end = graph[1];
            int w = graph[2];

            // costs 를 순회하며 부모 노드 비교 => union 서로소 집합
            int startParent = findParent(start);
            int endParent = findParent(end);

            // 부모가 같지 않다면 노드를 이어도 된다는 말
            // 노드를 이었으니 부모로도 이어질 수 있다
            if (startParent != endParent) {
                answer += w;
                parent[endParent] = startParent;
            }

        }

        return answer;
    }

    // 서로소 집합 부모를 찾을 때 까지
    public static int findParent(int node) {
        if (parent[node] == node)
            return node;
        return findParent(parent[node]);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
        System.out.println(solution(n, costs));
    }

}
