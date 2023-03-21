import java.util.*;

class Solution_1208 {

    public static void main(String args[])throws Exception {

        Scanner sc = new Scanner(System. in);
        int T;
        T = 1;

        for (int test_case = 1; test_case <= T; test_case++) {

            int dump = sc.nextInt();
            int[] box = new int[100];
            
            for(int i = 0 ; i < 100 ; i++){
                box[i] = sc.nextInt();
            }
            
            Arrays.sort(box);
            for(int i = 0 ; i < dump ; i++){
                box[0]++;
                box[99]--;
                Arrays.sort(box);
            }
            int ans = box[99]-box[0];
            System
                .out
                .println("#" + test_case + " " +ans);

        }
        sc.close();
    }
}
