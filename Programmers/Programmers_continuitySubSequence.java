import java.util.*;
import java.util.stream.Collectors;

public class Programmers_continuitySubSequence {
    public static int sum(int[] elements, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += elements[i % elements.length];
        }
        return sum;

    }

    public static int solution(int[] elements) {
        // int[] ele = new int[elements.length * 2];
        // for (int i = 0; i < elements.length; i++) {
        //     ele[i] = elements[i];
        //     ele[elements.length + i] = elements[i];
        // } -> 시간 초과 발생하는 것 같음

        Set<Integer> set = new HashSet<>();

    
        for (int len = 1; len <= elements.length; len++){
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < len + i; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
        }
      
        // System.out.println(set);

        int answer = set.size();

        return answer;
    }

    public static void main(String[] args) {
        int[] elements = { 7, 9, 1, 1, 4 };
        System.out.println(solution(elements));

    }

}
