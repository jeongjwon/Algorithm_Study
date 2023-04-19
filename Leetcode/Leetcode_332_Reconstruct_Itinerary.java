import java.util.*;

public class Leetcode_332_Reconstruct_Itinerary {
    public static void backtracking(Map<String, PriorityQueue<String>> graph, String airport, List<String> answer){
        
        PriorityQueue<String> arrivals = graph.get(airport);
        // System.out.println("현재 =>"+airport);
        while(arrivals != null && !arrivals.isEmpty()){
            String nextArrival = arrivals.poll();
            // System.out.println("next => "+nextArrival);
            backtracking(graph, nextArrival, answer);
        }
        answer.add(airport); //⭐️
        // System.out.println(answer);
        // System.out.println();
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        
        List<String> answer = new ArrayList<>();

        //ticket 정리
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            if(!graph.containsKey(departure)){
                graph.put(departure, new PriorityQueue<>());
            }
            graph.get(departure).offer(arrival);
        }
        // System.out.println(graph);
        
        //dfs
        backtracking(graph, "JFK", answer);


        Collections.reverse(answer);



        return answer;
    }
    public static void main(String[] args){
        List<List<String>> tickets = new ArrayList<>();

        // List<String> list = new ArrayList<>();
        // list.add("MUC");
        // list.add("LHR");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("JFK");
        // list.add("MUC");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("SFO");
        // list.add("SJC");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("LHR");
        // list.add("SFO");
        // tickets.add(new ArrayList<>(list));

        List<String> list = new ArrayList<>();
        list.add("JFK");
        list.add("KUL");
        tickets.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add("JFK");
        list.add("NRT");
        tickets.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add("NRT");
        list.add("JFK");
        tickets.add(new ArrayList<>(list));

        // List<String> list = new ArrayList<>();
        // list.add("JFK");
        // list.add("SFO");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("JFK");
        // list.add("ATL");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("SFO");
        // list.add("ATL");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("ATL");
        // list.add("JFK");
        // tickets.add(new ArrayList<>(list));

        // list = new ArrayList<>();
        // list.add("ATL");
        // list.add("SFO");
        // tickets.add(new ArrayList<>(list));
        
        
        List<String> res = findItinerary(tickets);
        System.out.println(res);
    }
}
