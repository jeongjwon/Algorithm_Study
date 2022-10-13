 import java.util.*;
class Solution {
    static ArrayList<String> allPath;
    static Queue<String> queue = new PriorityQueue<>();
    static boolean[] visited;
    public void dfs(String dep, String path, String[][] tickets, int depth){
        if(depth == tickets.length){
            //allPath.add(path);
            queue.add(path);
            return;
        }
        for(int i = 0 ; i < tickets.length ; i++){
            if(!visited[i] && dep.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], path+ " "+tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];
        allPath = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        // Collections.sort(allPath);
        // answer = allPath.get(0).split(" ");
        answer = queue.peek().split(" ");
        
        return answer;
    }
}
 // String[] answer = new String[tickets.length + 1];
        // HashMap<String, ArrayList<String>> hm = new HashMap<>();

        // ArrayList<String> arrivalList = new ArrayList<>();
        // Collections.sort(arrivalList);

        // for (int i = 0; i < tickets.length; i++) {
        // String dep = tickets[i][0];
        // String arr = tickets[i][1];
        // if (hm.containsKey(dep)) {
        // hm.get(dep).add(arr);
        // } else {
        // arrivalList = new ArrayList<>();
        // arrivalList.add(arr);
        // hm.put(dep, arrivalList);
        // }
        // }

        // System.out.println(hm);

        // ArrayList<String> ICNlist = new ArrayList<>(hm.get("ICN"));
        // Collections.sort(ICNlist);
        // String next = ICNlist.get(0);

        // hm.get("ICN").remove(next);
        // if (hm.get("ICN").size() == 0)
        // hm.remove("ICN");

        // answer[0] = "ICN";
        // answer[1] = next;
        // int idx = 2;

        // String prev = "";
        // for (int i = idx; i < answer.length; i++) {

        // if (hm.containsKey(next)) {
        // // 도착지가 있다면 도착지를 오름차순으로 정렬한 후
        // if (hm.get(next).size() >= 1) {
        // ArrayList<String> dep = new ArrayList<>(hm.get(next));
        // Collections.sort(dep);
        // prev = next;
        // next = dep.get(0);
        // }
        // hm.get(prev).remove(next);

        // answer[i] = next;
        // if (hm.get(prev).size() == 0) {
        // hm.remove(prev);
        // }

        // }
        // }
