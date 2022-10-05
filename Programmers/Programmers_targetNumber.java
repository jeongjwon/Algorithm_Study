import java.util.*;

public class Programmers_targetNumber {
    static int answer = 0;

    // public static void dfs(int[] numbers, int target, int depth, int sum) {
    // // System.out.println("dfs(" + depth + " , " + sum + ") => " + cnt);

    // if (depth == numbers.length) {
    // if (target == sum)
    // answer++;
    // //종료조건 : depth가 numbers 배열의 길이만큼 다 탐색했을 때
    // // target과 sum 이 같으면 answer 증가
    // } else {
    // dfs(numbers, target, depth + 1, sum + numbers[depth]);
    // dfs(numbers, target, depth + 1, sum - numbers[depth]);
    // }

    // }

    public static int dfs(int[] numbers, int depth, int sum, int target) {
        // 모든 경우의 수를 찾는 방법
        System.out.println("dfs(" + depth + "," + sum + ") => ");
        if (depth == numbers.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        return dfs(numbers, depth + 1, sum + numbers[depth], target)
                + dfs(numbers, depth + 1, sum - numbers[depth], target);

    }

    public static int solution(int[] numbers, int target) {

        // dfs(numbers, target, 0, 0);
        int res = dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void main(String[] args) {
        // int[] numbers = { 1, 1, 1, 1, 1 };
        // int target = 3;
        int[] numbers = { 4, 1, 2, 1 };
        int target = 4;

        System.out.println(solution(numbers, target));
    }

}

// dfs(0,0)
