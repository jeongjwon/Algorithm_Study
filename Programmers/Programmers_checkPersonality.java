import java.util.HashMap;

public class Programmers_checkPersonality {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int n = survey.length;
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] type = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
        // type으로 전체를 초기화

        for (int i = 0; i < type.length; i++) {
            hm.put(type[i], 0);
        }

        for (int i = 0; i < n; i++) {
            // Character c1 = survey[i].charAt(0);
            // Character c2 = survey[i].charAt(1);
            // switch (choices[i]) {
            //     case 1, 2, 3:
            //         hm.put(c1, hm.get(c1) + Math.abs(choices[i] - 4));
            //         // hm.put(c1, hm.getOrDefault(c1, 0) + Math.abs(choices[i] - 4));
            //         break;
            //     case 5, 6, 7:
            //         hm.put(c2, hm.getOrDefault(c2, 0) + choices[i] - 4);
            //         break;
            //     default:
            //         break;
            // }
        }
        System.out.println(hm);

        for (int i = 0; i < type.length; i += 2) {
            char ch = hm.get(type[i]) >= hm.get(type[i + 1]) ? type[i] : type[i + 1];
            answer += ch;
        }
        return answer;
    }

    public static void main(String[] args) {
        // RT CF JM AN
        // N 1 2 3 4 5 6 7 Y
        // N 3 2 1 0 1 2 3 A
        // 1 2 3 -> 3 2 1
        // 4 -> 0
        // 5 6 7 -> 1 2 3
        // l4-choices]

        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };
        System.out.println(solution(survey, choices));
    }

}
