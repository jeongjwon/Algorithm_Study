import java.util.*;
import java.io.*;

public class Baekjoon_1629_multiplication {

    static long A, B, C;

    public static long power(long base, long exponent) {
        // 밑, 지수
        if (exponent == 1)
            return base % C;

        long tmp = power(base, exponent / 2);

        if (exponent % 2 == 1) {// 홀수인 경우
            return (((tmp * tmp) % C) * base) % C;
        }
        // 모듈러 합동공식 -> 아직 어려움
        // (a*b)%c = (a%c)*(b%c) %c
        // (tmp * tmp * A) % C = ( (tmp * tmp % C) * (A % C)) % C
        // = ( ( (tmp * tmp % C) % C ) * (A % C) ) % C
        // = ( ( tmp * tmp % C ) * A ) % C
        return (tmp * tmp) % C;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(power(A, B));

    }
}
