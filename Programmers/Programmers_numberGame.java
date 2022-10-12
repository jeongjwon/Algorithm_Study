import java.util.*;

public class Programmers_numberGame {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0, b = 0;

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[a] + " " + B[b]);
            if (A[a] >= B[b]) {
                b++;

            } else {
                a++;
                b++;
                answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = { 5, 1, 3, 7 };
        int[] B = { 2, 2, 6, 8 };
        // int[] A = { 2, 2, 2, 2 };
        // int[] B = { 1, 1, 1, 1 };
        System.out.println(solution(A, B));
    }

}
