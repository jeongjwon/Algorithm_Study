import java.util.*;

public class Programmers_lifeboats {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        while (start <= end) {

            // System.out.println(people[start] + " " + people[end]);
            if (people[start] + people[end] > limit) {
                end--;
                answer++;
            } else {
                start++;
                end--;
                answer++;
            }

        }

        return answer;

    }
    // Greedy 탐욕법
    // 구명보트는 최대 2명씩이므로 합이 people[start]+people[end] 로만 가능
    // 어떻게 생각해보면 투포인터라고 생각해도 될 듯함

    public static void main(String[] args) {
        int[] people = { 70, 50, 80, 50 };
        // int[] people = { 70, 80, 50 };
        // int[] people = { 20, 50, 60, 80 };
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}
