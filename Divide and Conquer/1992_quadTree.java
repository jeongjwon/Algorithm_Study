import java.util.*;
import java.io.*;

public class Baekjoon_1992_quadTree {
    static int N;
    static int[][] arr;

    static void divide(int r, int c, int size) {

        if (isRight(r, c, size)) {
            if (arr[r][c] == 0) {
                System.out.print("0");
            } else
                System.out.print("1");
            return;

        }

        int reSize = size / 2;
        System.out.print("("); //(괄호 시작점)
        divide(r, c, reSize);
        divide(r, c + reSize, reSize);
        divide(r + reSize, c, reSize);
        divide(r + reSize, c + reSize, reSize);
        System.out.print(")");//(괄호 도착점)
    }

    static boolean isRight(int r, int c, int size) {

        int now = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != now)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = c[j] - '0';
            }

        }

        divide(0, 0, N);
    }
}
