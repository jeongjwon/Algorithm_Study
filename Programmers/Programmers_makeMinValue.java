import java.util.*;

public class Programmers_makeMinValue {

    public static int solution(int[] A, int[] B) {
       
        
        int a = 0;
        int b = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            a += A[i] * B[B.length - i - 1];
            b += B[i] * A[A.length - i - 1];
        }

        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };
        System.out.println(solution(A, B));
    }
}
