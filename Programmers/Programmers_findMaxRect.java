
public class Programmers_findMaxRect {
    public static int solution(int[][] board) {

        int row = board.length;
        int col = board[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[1001][1001];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                if (board[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }

                max = Math.max(max, dp[i][j]);
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }
        // 0 1 1 1
        // 1 1 1 1
        // 1 1 1 1
        // 0 0 1 0
        // 0 1 1 1

        // 0 0 0 0

        return max * max;

    }

    public static void main(String[] args) {
        int[][] board = { { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 1, 0 } };

        System.out.println(solution(board));

    }
}
