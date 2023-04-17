import java.util.*;

public class Leetcode_332_Reconstruct_Itinerary {
    public static void backtracking(Map<String, List<String>> graph){
        

        for(String departure: graph.keySet()){
            List<String> arrivals = graph.get(departure);
            if(arrivals.size() > 0){
                for(String arrival : arrivals){
                    graph.get(departure).remove(arrival);
                    backtracking(graph);
                }
            }else{
                graph.remove(departure);
            }
        }
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        
        List<String> answer = new ArrayList<>();

        //ticket 정리
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            if(!graph.containsKey(departure)){
                graph.put(departure, new ArrayList<>());
            }
            graph.get(departure).add(arrival);
        }
        System.out.println(graph);
        
        //dfs
        // backtracking(graph);

      



        return answer;
    }
    public static void main(String[] args){
        List<List<String>> tickets = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("MUC");
        list.add("LHR");
        tickets.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add("JFK");
        list.add("MUC");
        tickets.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add("SFO");
        list.add("SJC");
        tickets.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add("LHR");
        list.add("SFO");
        tickets.add(new ArrayList<>(list));
        
        List<String> res = findItinerary(tickets);
        System.out.println(res);
    }
}
