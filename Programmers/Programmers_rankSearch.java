import java.util.*; 

public class Programmers_rankSearch {
    // Step 1 : info 를 이용하여 hashmap(모든 조건이 가능하게끔)을 만든다
    // Step 2 : hashmap(조건String , 가능한 점수ArrayList) -> 점수를 기준으로 오름차순 정렬
    // Step 3 : query 조건에 맞게끔 hashmap에서 찾는다

    public static int[] solution(String[] info, String[] query) {
        // Step 1 > info를 hashmap으로
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

        for (String i : info) {
            String[] data = i.split(" ");
            String[] langs = { data[0], "-" };
            String[] jobs = { data[1], "-" };
            String[] careers = { data[2], "-" };
            String[] foods = { data[3], "-" };
            // 조합을 하기 위해서 새로운 배열을 만들어줌
            Integer score = Integer.parseInt(data[4]);

            for (String lang : langs) {
                for (String job : jobs) {
                    for (String career : careers) {
                        for (String food : foods) {
                            String[] keyData = { lang, job, career, food };
                            String key = String.join(" ", keyData);
                            // hm에 넣어줄 key값을 join시킴
                            ArrayList<Integer> arr = hm.getOrDefault(key, new ArrayList<>());
                            arr.add(score);
                            // hm에 key값이 있다면 기존의 value인 ArrayList를 다시 가져와서 score 추가
                            hm.put(key, arr);
                        }
                    }
                }
            }
        }
        // Step 2> value값을 기준으로 오름차순 정렬
        for (ArrayList<Integer> sorted : hm.values()) {
            sorted.sort(null);
        }

        // Step 3> query 기준에 맞는 지원자 수 세기
        int[] answer = new int[query.length];
        int i = 0;

        for (String q : query) {

            String[] data = q.split(" and ");
            // 마지막 data[3]의 형태는 "${foods} ${target}" 이기 때문에 다시 split
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if (hm.containsKey(key)) {
                ArrayList<Integer> list = hm.get(key);

                // ***** list를 가져와 이분탐색으로 지원자 수를 셈
                int left = 0;
                int right = list.size();

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }

                }
                answer[i] = list.size() - right;
                // 멈추는 값(target보다 작은 인덱스 값)
                // left or right 이든 상관없음
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"

        };
        int[] res = solution(info, query);
        for (int r : res)
            System.out
                    .println(r);
    }
}

// info 개발언어 cpp, java, phyton 직군 backend frontend 경력 junior senior 소울푸드 chicken
// pizza 점수 1 ~ 100 query
// - and
//
