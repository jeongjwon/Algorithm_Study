import java.util.*;

class Solution_1284 {

    public static void main(String args[])throws Exception {

        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int p = sc.nextInt();

            int q = sc.nextInt();// 기준이하인 경우 q
            int r = sc.nextInt(); //기준 
            int s = sc.nextInt(); // 기준 초과인 경우 s * w

            int w = sc.nextInt();

            int a = p * w;
            int b = w <= r ? q : q + (w-r) * s;
		
			
            int min = Math.min(a, b);
            System
                .out
                .println("#" + test_case + " " + min);

        }
        sc.close();
    }
}
