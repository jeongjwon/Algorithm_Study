import java.util.*;
import java.io.*;

public class Baekjoon_1780_theNumberofPaper {
    static int N;
    static int[][] arr;
    static int cntMinusOne = 0, cntZero = 0, cntOne = 0;

    static void divide(int r, int c, int size) {
        
      
        
        if (isRight(r, c, size)) {
            if (arr[r][c] == -1) {

                cntMinusOne++;
            } else if (arr[r][c] == 0) {
                cntZero++;

            } else {

                cntOne++;
            }

            return;

        }
        

        int reSize = size / 3;
        
        // 4등분 -> 9등분
        // 밑의 주식처리한 부분의 범위를 생각하느라 시간이 걸림 
        // 그치만 reSize를 이용하여 조금 수월하게 품

        divide(r, c, reSize);
        divide(r, c + reSize, reSize);
        divide(r, c + reSize * 2, reSize); //

        divide(r + reSize, c, reSize);
        divide(r + reSize, c + reSize, reSize);
        divide(r + reSize, c + reSize * 2, reSize); //

        divide(r + reSize * 2, c, reSize); //
        divide(r + reSize * 2, c + reSize, reSize); //
        divide(r + reSize * 2, c + reSize * 2, reSize); //

        
        
    }

    static boolean isRight(int r, int c, int size) {

        int num = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != num)
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(cntMinusOne);
        System.out.println(cntZero);
        System.out.println(cntOne);

    }
}
