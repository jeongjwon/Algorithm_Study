
import java.io.*;

public class Baekjoon_1541_lostBracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cal = br.readLine().split("-");
        int res = 0;
        for (int i = 0; i < cal.length; i++) {
            int sum = 0;
            String[] temp = cal[i].split("\\+");
            for (int j = 0; j < temp.length; j++) {
                sum += Integer.parseInt(temp[j]);
            }
            if (i == 0) {

                res += sum;
            } else {
                res -= sum;
            }

        }
        System.out.println(res);

    }
}
