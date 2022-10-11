import java.util.*;

public class Programmers_bestAlbum {
    public static int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> hm = new HashMap<>(); // 장르, 재생횟수 합
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르 , <인덱스, 재생횟수>

        for (int i = 0; i < genres.length; i++) {
            if (!hm.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);// 인덱스 고유번호
                music.put(genres[i], map);
                hm.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
            }

        }

        // hm -> 재생횟수 기준으로 내림차순 -> keySet
        ArrayList<String> keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet, (o1, o2) -> hm.get(o2) - hm.get(o1));

        // music -> map의 재생횟수 기준으로 내림차순
        for (String key : keySet) { // key = music의 key값
            HashMap<Integer, Integer> map = music.get(key);

            ArrayList<Integer> playcount = new ArrayList<>(map.keySet());
            Collections.sort(playcount, (o1, o2) -> map.get(o2) - map.get(o1));

            answer.add(playcount.get(0));
            if (playcount.size() > 1) {
                answer.add(playcount.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {
                "classic",
                "pop",
                "classic",
                "classic",
                "pop"
        };
        int[] plays = {
                500,
                600,
                150,
                800,
                2500
        };
        int[] res = solution(genres, plays);
        for (int r : res) {
            System.out
                    .println(r);
        }
    }
}
