import java.util.*;


class Programmers_makeBwithA{
    public static int solution(String before, String after) {
        int answer = 0;

        //나의 풀이 : hashmap 을 이용하여 각 문자열에 포함된 문자의 갯수를 쌍으로 계산하여 비교 
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : after.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map);
        for(Character ch : before.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else {
                    map.put(ch, map.get(ch)-1);
                }
            }else {
                answer = 0;
                break;
            }
        }
        System.out.println(map);
        if(map.isEmpty()){
            answer = 1;
        }
        else answer =0;


        //다른 사람 풀이 : hashmap 보다는 더 간단하게 char형 배열을 이용하여 비교
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();

        Arrays.sort(b);
        Arrays.sort(a);

      
        answer = Arrays.equals(a,b) ? 1: 0;


        return answer;
    }
    public static void main(String[] args) {

        String before = "olleh";
        String after = "hello";
        System.out.println(solution(before, after));
    }
}