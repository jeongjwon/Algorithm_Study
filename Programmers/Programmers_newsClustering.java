import java.util.*;

public class Programmers_newsClustering {

    public static int solution(String str1, String str2) {
        
        ArrayList<String> map1 = new ArrayList<>();
        ArrayList<String> map2 = new ArrayList<>();

        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        if (str1.length() == 0 || str2.length() == 0)
            return 65536;

        //대소문자 구분없으므로 대문자로 변환
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

      
        // 문자열 끊어주기 -> 공백, 특수문자, 숫자 제외 -> matches 

        String match = "[A-Z]+";
        for (int i = 0; i < str1.length() - 1; i++) {

            String str = str1.substring(i, i + 2);
            if (!str.matches(match)) {
                // System.out.println(str + "숫자나 공백, 특수문자 포함");
                continue;
            }

            map1.add(str);
        }

        for (int i = 0; i < str2.length() - 1; i++) {

            String str = str2.substring(i, i + 2);

            if (!str.matches(match)) {
                // System.out.println(str + "숫자나 공백, 특수문자 포함");
                continue;
            }

            map2.add(str);

        }

        Collections.sort(map1);
        Collections.sort(map2);

        for (String s : map1) {
          //둘다 있다면 교집합 리스트에 추가하고 map2에 지워주기-> min, max
            if (map2.contains(s)) {
                intersection.add(s);
                map2.remove(s);
            }
            union.add(s);
        }

        for (String s : map2) {
            union.add(s);
        }

        // System.out.println(intersection);
        // System.out.println(union);
        double jakad = 0;
        if (union.size() == 0) {
            jakad = 1;
        } else {
            jakad = (double) intersection.size() / (double) union.size();
        }

        return (int) (jakad * 65536);
    }

    public static void main(String[] args) {

        // String str1 = "FRANCE";
        // String str2 = "french";
        // String str1 = "handshake";
        // String str2 = "shake hands";
        // String str1 = "aa1+aa2";
        // String str2 = "AAAA12";
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(solution(str1, str2));
    }

}
