import java.util.*;

public class Programmers_checkPermutation {
    public static boolean solution(int[] arr) {
        boolean answer = true;
        Arrays.sort(arr);
        if (arr.length != arr[arr.length - 1])
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i])
                return false;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 1, 3 };
        System.out.println(solution(arr));

    }
}