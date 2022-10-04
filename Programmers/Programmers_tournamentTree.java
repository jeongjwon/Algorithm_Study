import java.util.*;

public class Programmers_tournamentTree {
    static int n, a, b;
    static ArrayList<int[]> list = new ArrayList<>();
    static HashMap<Integer, Integer> hm = new HashMap<>();

    // public static void divide(int start, int end, int times) {

    // if (end <= start)
    // return;

    // int mid = (start + end) / 2;
    // // System.out.println("divide(" + start + "," + end + "," + times + ")");
    // if (start == a || end == a) {
    // hm.put(a, Math.max(hm.getOrDefault(a, 0), times));
    // list.add(new int[] { a, times });
    // } else if (start == b || end == b) {
    // hm.put(b, Math.max(hm.getOrDefault(a, 0), times));
    // list.add(new int[] { b, times });
    // }

    // divide(start, mid, times + 1);
    // divide(mid + 1, end, times + 1);

    // }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        // divide(1, n, 1);

        // System.out.println(hm);
        // int max = 0;
        // for (int values : hm.values()) {
        // max = Math.max(max, values);
        // }
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        n = 8;
        a = 4;
        b = 7;
        System.out.println(solution(n, a, b));
    }

}
