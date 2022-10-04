import java.util.*;

public class Programmers_openChatRoom {
    public static String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String, String> hm = new HashMap<>();

        int cnt = 0; //enter 와 leave의 개수로 answer 배열의 크기를 지정해줌

        //Step 1: 배열을 탐색하면서 hashmap 에 최종적으로 <유저id, 닉네임> 을 정리해줌
        for (String str : record) {
            String[] s = str.split(" ");
            // s[0] = Enter / Leave
            // s[1] = uid
            // s[2] = nickname

            if (s[0].equals("Enter")) {
                hm.put(s[1], s[2]);
                cnt++;
            } else if (s[0].equals("Change")) {
                hm.put(s[1], s[2]);
            } else if (s[0].equals("Leave")) {
                cnt++;
            }
        }
        //System.out.println(hm);
        answer = new String[cnt];

        //Step 2: 정리된 hashmap을 탐색하면서 enter와 leave일 때를 봐가며 문장을 완성시킴
        int i = 0;
        for (String str : record) {
            String[] s = str.split(" ");
            if (s[0].equals("Enter")) {
                answer[i++] = hm.get(s[1]) + "님이 들어왔습니다.";
            } else if (s[0].equals("Leave")) {
                answer[i++] = hm.get(s[1]) + "님이 나갔습니다.";
            }
           
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] res = solution(record);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
