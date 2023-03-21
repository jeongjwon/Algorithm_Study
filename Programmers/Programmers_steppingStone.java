
public class Programmers_steppingStone {
    public static boolean check(int mid, int k, int[] stones) {
        int cnt = 0;

        for (int s : stones) {
            if (s < mid) {
                // mid 가 크다면 못 건넌다는 말
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == k) {
                // 못 건너는 사람이 k 만큼이라면
                return false;

            }
        }
        return true;
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
       
        // 이분탐색 -> 건너는 사람의 수
        int min = 0;
        int max = Integer.MAX_VALUE;

        while (min <= max) {
            int mid = (min + max) / 2;
            System.out.println("mid:" + mid);
            if (check(mid, k, stones)) {
                // 건널 수 있으면 중간 값보다 작은 값도 건널 수 있으므로
                // min 값을 늘여주고 다시 while문
                // 최대 mid를 찾는다.

                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                // 건널 수 없다면 중간 값보다 큰 값들은 건널 수 없으므로
                // max 값을 줄여주고 다시 while문
                max = mid - 1;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        int k = 3;
        System.out.println(solution(stones, k));
    }

}
