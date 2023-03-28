import java.util.*;
public class Leetcode_819_MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        
        //banned 는 소문자로만 이루어져있으므로 비교를 쉽게 하기 위해 paragraph 도 소문자로 변경
        // paragraph = paragraph.toLowerCase(); 
        // //banned 는 영어로만 이루어져있으므로  공백, ! ? ; , ; .  제거
        // String regex = "[^a-z ]";
        // paragraph = paragraph.replaceAll(regex, " ");
        // //banned 한 문자열 제거
        // for(String ban : banned){
        //     paragraph = paragraph.replaceAll(ban, " ");
        // }
        paragraph = paragraph.toLowerCase();
paragraph = paragraph.replaceAll("[!?',;.]", " ");
paragraph = paragraph.replaceAll("\\s+", " ");
        System.out.println(paragraph);
        //띄어쓰기를 기준으로 split
        String[] words = paragraph.split(" ");
        
        for(String word : words) System.out.println("\\"+word+"\\");

        HashMap<String, Integer> hashmap = new HashMap<>();

        for(String word : words){
            //공백이나 아무의미없는 값은 건너뛰기
            if(word.equals(" ") || word.equals("")) continue;
            else {  
                hashmap.put(word, hashmap.getOrDefault(word, 0)+1);
            }
        }

        List<Integer> count = new ArrayList<>(hashmap.values());
        Collections.sort(count, Collections.reverseOrder());
        int max = count.get(0);

        String result = "";
        
        for(String key : hashmap.keySet()){
            if(hashmap.get(key).equals(max)){
                result = key;
                break;
            }
        }
    
        return result;

    }
    public static void main(String[] args) {
        // String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        // String[] banned = {"hit"};
        // String paragraph = "a.";
        // String[] banned = {};
        // String paragraph = "Bob. hIt, baLl";
        // String[] banned = {"bob", "hit"};
        // String paragraph = "a, a, a, a, b,b,b,c, c";
        // String[] banned = {"a"};
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = {"abc","abcd","jeff"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
