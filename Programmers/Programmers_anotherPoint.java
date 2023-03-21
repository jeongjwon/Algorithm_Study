import java.util.HashMap;

public class Programmers_anotherPoint {
    public static int[] solution(int[][] v) {
        HashMap<String, Integer> hm = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < v.length; i++) {
            hm.put("L" + v[i][0], hm.getOrDefault("L" + v[i][0], 0) + 1);
            hm.put("R" + v[i][1], hm.getOrDefault("R" + v[i][1], 0) + 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key).equals(1)) {
                if (key.charAt(0) == 'L') {
                    res[0] = Integer.parseInt(key.substring(1));
                } else {
                    res[1] = Integer.parseInt(key.substring(1));
                }

            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] v = { { 1, 4, }, { 3, 4 }, { 3, 10 } };
        int[] res = solution(v);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
