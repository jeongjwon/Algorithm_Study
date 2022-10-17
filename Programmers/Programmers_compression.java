import java.util.*;

public class Programmers_compression {
    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        HashMap<String, Integer> LZW = new HashMap<>();

        for (char c = 65; c <= 90; c++) {
            LZW.put(String.valueOf(c), (int) c - 64);
        }

        int idx = 27;
        boolean isEnd = false;

        for (int i = 0; i < msg.length(); ++i) {
            String str = msg.charAt(i) + ""; // 현재

            while (LZW.containsKey(str)) {

                i++;
                if (i == msg.length()) {
                    isEnd = true;
                    break;
                }
                str += msg.charAt(i);
                // 다음 문자 합성하여 있으면 계속 keep
            }

            if (isEnd) {
                list.add(LZW.get(str));
                // 마무리로 str 넣어줌
                break;
            }
            // while 문이 종료된 시점에서의 str은 아직 포함되지 않은 값이기 때문에
            // 그전의 값으로 저장 , 인덱스 또한 감소
            list.add(LZW.get(str.substring(0, str.length() - 1)));
            LZW.put(str, idx++);
            i--;

        }
        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] res = solution(msg);
        for (int r : res) {
            System.out.println(r);
        }
    }

}
