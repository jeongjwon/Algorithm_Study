import java.util.HashMap;

public class Leetcode_happyNumber {
    public static boolean isHappy(int n) {
        boolean res = false;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (sum != 1) {

            sum = 0;
            if (hm.containsKey(n)) {
                return false;
            } else
                hm.put(n, 1);

            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }

            n = sum;
            if (sum == 1)
                return true;

        }
        return res;

    }

    public static void main(String[] ars) {
        int n = 19;
        System.out.println(isHappy(n));
    }
}
