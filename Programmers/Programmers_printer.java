import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_printer{
    public static int solution(int[] priorities, int location) {
        int answer = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위큐 

        for(int i = 0 ; i < priorities.length ; i++){
           pq.add(priorities[i]);
        }
        
        // System.out.println(pq);
        
        //내림차순으로 정렬된 우선순위 큐에서 priorities 배열과 비교하고 location 도 비교하여 바로 return 가능하게
        //location 이 맞다면 order이기 때문에 answer + 1 값 리턴
        //           아니라면 location 찾을 때까지 answer 을 증가시키고 우선순위큐에서 삭제
        
        while(!pq.isEmpty() ){
            for(int i = 0 ; i < priorities.length ; i++){
                if(priorities[i] == pq.peek()){
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                    
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        // int[] priorities = {2,1,3,2};
        // int location = 2;

        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
}
