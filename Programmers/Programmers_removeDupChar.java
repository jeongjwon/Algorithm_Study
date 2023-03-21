import java.util.*;

class Programmers_removeDupChar {
    public static String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        //Set 을 이용하여 중복 문자 제거
        Set<Character> set = new HashSet<>();
        for(char c : my_string.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
            
        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        String my_string = "We are the world";
        System.out.println(solution(my_string));
    }
}
