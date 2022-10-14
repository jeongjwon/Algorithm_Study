import java.util.*;

public class Programmers_Cache {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 캐시교체 알고리즘 LRU

        ArrayList<String> cache = new ArrayList<>();

        for (String city : cities) {
            city = city.toUpperCase(); // 대소문자 구분 없이 비교하기 위함

            if (cache.contains(city)) {
                // 이미 있다면 hit
                cache.remove(city);
                cache.add(city);
                // 지워주고 다시 넣어줌 -> hit
                answer += 1;
            } else {
                // 없다면 miss-> 일단 넣어주고 사이즈가 안 맞으면 제일 앞 삭제
                cache.add(city);
                answer += 5;
                if (cache.size() > cacheSize) {
                    cache.remove(0);
                }
            }
            System.out.println(cache + " , " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 2;
        // String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
        // "Pangyo", "Seoul", "NewYork", "LA" };
        // String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul",
        // "Jeju", "Pangyo", "Seoul" };
        String[] cities = { "Jeju", "Pangyo", "Newyork", "newyork" };
        System.out.println(solution(cacheSize, cities));
    }

}
