import java.util.*;

public class Programmers_badUser {
    static HashSet<HashSet<String>> res; // 불량 사용자

    public static int solution(String[] user_id, String[] banned_id) {

        res = new HashSet<HashSet<String>>();

        dfs(user_id, banned_id, new LinkedHashSet<>());

        return res.size();
    }

    // 모든 경우의 수 세팅
    public static void dfs(String[] user_id, String[] banned_id, HashSet<String> set) {

        if (set.size() == banned_id.length) {

            if (isBannedUsers(set, banned_id)) {
                res.add(new HashSet<>(set));

            }
            return;
        }
        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                set.remove(userId);
            }
        }
    }

    public static boolean isBannedUsers(HashSet<String> set, String[] banned_id) {
        int idx = 0;
        for (String user : set) {
            if (!isSame(user, banned_id[idx++])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSame(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*')
                continue;
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr*d*", "abc1**" };
        System.out.println(solution(user_id, banned_id));
    }

}
