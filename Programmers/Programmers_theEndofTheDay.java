
import java.util.*;

public class Programmers_theEndofTheDay {
    public static int[] solution(int n, String[] words) {
        int[] answer = { 0, 0 };

        ArrayList<String> list = new ArrayList<>();

        int order = 0;
        list.add(words[0]);
        String prev = words[0];
        int last = prev.length() - 1;
        for (int i = 1; i < words.length; i++) {
            if (!list.contains(words[i])) {
                list.add(words[i]);

                if (prev.charAt(last) == words[i].charAt(0)) {
                    list.add(words[i]);
                } else {
                    System.out.println(i + "번째 끝말잇기가 안됨");
                    order = i;

                    break;
                }

            } else {
                System.out.println(i + "번째 이미 언급");

                order = i;
                break;

            }
            prev = list.get(list.size() - 1);
            last = prev.length() - 1;
        }
        if (order != 0) {
            answer[0] = order % n + 1;
            answer[1] = order / n + 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 2;
        // String[] words = { "tank", "kick", "know",
        // "wheel", "land", "dream",
        // "mother", "robot", "tank" };
        String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
        int[] res = solution(n, words);
        for (int r : res)
            System.out.print(r + " ");

    }
}
