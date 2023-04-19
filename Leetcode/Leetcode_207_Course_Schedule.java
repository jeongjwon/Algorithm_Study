import java.util.*;
public class Leetcode_207_Course_Schedule {
    
    public static boolean isCycle(List<List<Integer>> graph, boolean[] visited, boolean[] recStack, int start){

        visited[start] = true;
        recStack[start] = true;

        List<Integer> nextSubjects= graph.get(start);
        System.out.println("현재 cur " + start + " 에서 갈 수 있는 곳 => "+nextSubjects );

        for(int next : nextSubjects){
            if(!visited[next]){
                if(isCycle(graph, visited, recStack, next)){
                    return true;
                }
            }else if(recStack[next]){
                return true;
            }
            System.out.println();
        }
        return false;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //false를 반환하는 경우는 cycle이 발생되는 경우 !
        
        // Map<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();//unique 하다고 했으니

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length ; i++){
            int second = prerequisites[i][0];
            int first = prerequisites[i][1];
            // if(!graph.containsKey(first)){
            //     graph.put(first, new ArrayList<>());
            // }

            graph.get(first).add(second);
        }
        System.out.println(graph);

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i] && isCycle(graph, visited, recStack, i)) return true;
            
        }
        return false;
    }
    
    public static void main(String[] args){
        // int numCourses = 2;
        // int[][] prerequisites = { {1,0}, {0,1} };
        //a,b => b를 먼저 이수해야 a를 이수할 수 있다 -> 그래프 b->a

        // int numCourses = 4;
        // int[][] prerequisites = { {1,0}, {2,0}, {3,1}, {3,2} };
        //0-> 1, 2
        //1 -> 3
        //2-> 3
        
        int numCourses = 3;
        int[][] prerequisites = { {1,0}, {2,1}, {0,2}};
        //0 -> 1 
        //1 -> 2
        //2 -> 0

        System.out.println(canFinish(numCourses, prerequisites));
        

    }
}
