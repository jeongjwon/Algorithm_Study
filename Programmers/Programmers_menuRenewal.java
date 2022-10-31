
import java.util.*;

public class Programmers_menuRenewal {
    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hm = new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {

        //1. orders를 알파벳 순으로 정렬
        for(int i = 0 ; i < orders.length ; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        //2. course의 수만큼 가능한 조합 만들어서 가장 높은 빈도수만 answer에 추가
        for(int courseLen : course){
            for(String order: orders){
                dfs("", order, courseLen);
            }
           
            if(!hm.isEmpty()){
                List<Integer> countList = new ArrayList<>(hm.values());
                int max = Collections.max(countList);

                if(max > 1){
                    for(String key : hm.keySet()){
                        if(hm.get(key) == max){
                            answerList.add(key);
                        }
                    }
                }
                hm.clear();
                
            }

        }
        
        Collections.sort(answerList);
        
        String[] answer = new String[answerList.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
        
    }

    // 조합 만들어 주기
    static void dfs(String order, String others, int count) {
       if(count == 0){
            hm.put(order, hm.getOrDefault(order, 0)+1);
            return;
        }
        for(int i = 0 ; i < others.length() ; i++){
            dfs(order + others.charAt(i), others.substring(i+1),count-1);
        }
      
        

    }

    public static void main(String[] args) {
        // String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        // String[] orders = { "XYZ", "XWY", "WXA" };
        // int[] course = { 2, 3, 4 };
        String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
        int[] course = { 2, 3, 5 };
        String[] res = solution(orders, course);
        for (String r : res)
            System.out.println(r);

    }
}
