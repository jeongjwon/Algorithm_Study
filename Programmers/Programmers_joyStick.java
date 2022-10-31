import java.util.*;

public class Programmers_joyStick {
    public static int solution(String name) {
        int answer = 0;
        //up -> 다음 알파벳
        //down-> 이전 알파벳 A -> Z
        //left -> 커서 왼쪽으로 이동 첫번째에서 마지막 인덱스
        //right-> 커서 오른쪽 이동 마지막에서 첫번째 인덱스
        //AAAAA

        //1. name의 길이만큼 A를 대체해줌
        int len = name.length();

        int move = len-1;
        
        for(int i = 0 ; i  < len ; i++){
                char c = name.charAt(i);
                int times = Math.min(c - 'A', 'Z' - c + 1);
                answer += times;

                int index= i+1;
                //다음 A의 갯수 확인
                while(index < len && name.charAt(index) == 'A'){
                    index++;
                }
                //연속된 A 앞과 뒤의 알파벳 갯수 비교
                //앞 < 뒤 :  앞을 진행후 다시 0으로 지난 후 뒤로 가서 index 까지
                move = Math.min(move, i*2+len-index);

                //앞 > 뒤 : 뒤를 진행 후 다시 0으로 간 후 i까지
                move = Math.min(move, i + (len-index)*2);
            
        }
         
        return answer + move;
    }
    public static void main(String[] args) {
        // String name = "JEROEN";
        String name = "BBAAAAAAYYY"; 
        // String name = "BBAAAAAAAY";
        System.out.println(solution(name));
    }
}
