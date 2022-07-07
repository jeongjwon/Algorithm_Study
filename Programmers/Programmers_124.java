public class Programmers_124 {
    public static String solution(int n) {
        String answer = "";

        // 실행시간 10초 오버
        // int cnt = 0;
        // for (int i = 1;; i++) {
        // if (cnt == n) {
        // return Integer.toString(i);
        // }
        // if (Integer.toString(i).contains("1") || Integer.toString(i).contains("2")
        // || Integer.toString(i).contains("4")) {
        // cnt++;
        // }
        // }

        String[] numbers = { "4", "1", "2" };
        // 1,2,4 세 가지 숫자로 이루어져 있기 때문으로 n을 3으로 나눈 값을 이용
        int r = 0;
        while (n > 0) {
            r = n % 3; // 나머지
            n /= 3;
            if (r == 0) // 나머지가 0인 경우를 생각해줘야 함-> while문을 한번 감소 시킴
                n--;
            answer = numbers[r] + answer; // += 가 아니라
        }
        return answer;

    }

    public static void main(String[] args) {
        int n = 4;
        System.out
                .println(solution(n));

    }
}
