

public class Programmer_level2 {
    // public static String[] solution(String[] record) {
    // String[] answer = {};
    // HashMap<String, String> hm = new HashMap();

    // int cnt = 0;
    // for (String s : record) {
    // String[] str = s.split(" ");
    // String situation = str[0];
    // String uid = str[1];
    // // String nickname = str[2];
    // if (situation.equals("Enter")) {
    // hm.put(uid, str[2]);
    // cnt++;
    // } else if (situation.equals("Change")) {
    // hm.put(uid, str[2]);
    // } else
    // cnt++;
    // }
    // answer = new String[cnt];
    // int i = 0;
    // for (String s : record) {
    // String[] str = s.split(" ");
    // if (str[0].equals("Enter")) {
    // answer[i++] = hm.get(str[1]) + "님이 들어왔습니다.";
    // } else if (str[0].equals("Leave")) {
    // answer[i++] = hm.get(str[1]) + "님이 나갔습니다.";
    // }
    // }
    // //System.out.println(hm);
    // return answer;
    // }

    static int answer = 0, n;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {

        // 피로도 시스템 -> 일정피로도(최소필요 피로도 , 소모피로도)
        // Arrays.sort(dungeons, (o1, o2) -> {

        // return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        // });
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k, dungeons, 0, visited);

        return answer;
    }

    public static void dfs(int k, int[][] dungeons, int depth, boolean[] visited) {
        answer = Math.max(answer, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // String[] record = {
        // "Enter uid1234 Muzi",
        // "Enter uid4567 Prodo",
        // "Leave uid1234",
        // "Enter uid1234 Prodo",
        // "Change uid4567 Ryan"
        // };
        // String[] res = solution(record);

        int k = 80;
        int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
        System.out.println(solution(k, dungeons));
    }
}
