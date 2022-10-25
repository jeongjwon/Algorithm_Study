import java.util.*;

public class Programmers_QuadPress {
    static int oneCnt = 0;
    static int zeroCnt = 0;

    public static void divide(int r, int c, int size, int[][] arr) {
        System.out.println("divide(" + r + "," + c + "," + size + ")");

        if (isSame(r, c, size, arr)) {
            // 범위 안의 정사각형 수가 다 일치한다면

            if (arr[r][c] == 1) {
                oneCnt++;
            } else {
                zeroCnt++;
            }
            System.out.println("모두 일치 => zero : " + zeroCnt + " , one : " + oneCnt);
            return;
        }
        if (size == 1)
            return;

        int halfSize = size / 2;
        divide(r, c, halfSize, arr);
        divide(r, c + halfSize, halfSize, arr);
        divide(r + halfSize, c, halfSize, arr);
        divide(r + halfSize, c + halfSize, halfSize, arr);
    }

    public static boolean isSame(int r, int c, int size, int[][] arr) {
        // 범위 안에 있는 수가 다 같은지
        int tmp = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;

        divide(0, 0, n, arr);

        answer[0] = zeroCnt;
        answer[1] = oneCnt;
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0, 0 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 } };
        int[] res = solution(arr);

        System.out.println(res[0] + " , " + res[1]);
    }

}
