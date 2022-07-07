public class Programmers_binaryRepeat {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int times = 0;
        int cnt = 0;
        while (!s.equals("1")) {
            int fromLen = s.length();
            s = s.replaceAll("0", "");
            int toLen = s.length();

            int zeroCnt = (fromLen - toLen);
            cnt += zeroCnt;

            String binaryString = Integer.toBinaryString(toLen);
            s = binaryString;
            times++;
        }
        answer[0] = times;
        answer[1] = cnt;

        return answer;
    }

    public static void main(String[] args) {
        // String s = "110010101001";
        // String s = "01110";
        String s = "1111111";
        int[] res = solution(s);
        for (int r : res)
            System.out.println(r);
    }

}
