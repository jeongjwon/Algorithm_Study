import java.util.*;
import java.io.*;

public class Baekjoon_2630_makeColorpaper {
    static int[][] arr;
    static int N;
    static int cntBlue = 0, cntWhite = 0;

    public static void divide(int row, int col, int size) {

        //true 라면 정사각형을 갖는다는 의미
        //정사각형중 좌측 맨위의 색에 따라 정사각형 갯수 카운트
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 0)
                cntWhite++;
            else
                cntBlue++;
            return;

        }//정복

        //분할
        int newSize = size / 2;
        
        
        divide(row, col, newSize); //2사분면
        divide(row, col + newSize, newSize); //1사분면
        divide(row + newSize, col, newSize); //3사분면
        divide(row + newSize, col + newSize, newSize); //4사분면

    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];
        //좌측 상단의 컬러를 기준으로 size만큼의 정사각형의 색을 비교
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
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

        divide(0, 0, N);//분할

        StringBuilder sb = new StringBuilder();
        sb.append(cntWhite).append('\n').append(cntBlue);
        System.out.println(sb);
    }
}
