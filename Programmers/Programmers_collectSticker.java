public class Programmers_collectSticker {
    public static int solution(int sticker[]) {

        int[] dp1 = new int[100001];
        int[] dp2 = new int[100001];
        int n = sticker.length;

        if (n == 1)
            return sticker[0];

        // 1. 첫번째 스티커를 뜯는 경우 -> 마지막 인덱스 포함하지 않음
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];

        // 2. 첫번째 스티커를 뜯지 않는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        return dp1[n - 2] > dp2[n - 1] ? dp1[n - 2] : dp2[n - 1];

    }

    public static void main(String[] args) {
        // int[] sticker = { 14, 6, 5, 11, 3, 9, 2, 10 };
        int[] sticker = { 1, 3, 2, 5, 4 };
        System.out.println(solution(sticker));

    }
}
