import java.util.*;

public class Programmers_vowelDictionary {
    public static int solution(String word) {
        int answer = 0;
        int[] vowel = { 781, 156, 31, 6, 1 };
        String str = "AEIOU";
        int len = word.length();

        for (int i = 0; i < word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += vowel[i] * idx;
        }
        answer += len;

        return answer;
    }

    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
