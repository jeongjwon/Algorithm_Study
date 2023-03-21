import java.util.*;

public class Programmers_tripRoute {
    static boolean[] visited;
    static ArrayList<String> allRoute;
    static int depth = 0;

    public static void dfs(String dep, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            allRoute.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (dep.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }

    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, depth);

        Collections.sort(allRoute);
        // System.out.println(allRoute);
        answer = allRoute.get(0).split(" ");
        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }
        };
        // String[][] tickets = {
        // { "ICN", "SFO" },
        // { "ICN", "ATL" },
        // { "SFO", "ATL" },
        // { "ATL", "ICN" },
        // { "ATL", "SFO" } };
        String[] res = solution(tickets);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
