import java.util.*;

public class Leetcode_49_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();

        //strs 배열의 모든 문자열의 각각 요소를 hashmap으로 {String 각 문자열을 정렬한 값, ArrayList}
        // List<String> consistCharaterList = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String charToStr= String.valueOf(chars);
           
            if(map.containsKey(charToStr)){
                List<String> temp = map.get(charToStr);
                temp.add(str);
                map.put(charToStr, temp);
            }else{
                List<String> consistCharaterList = new LinkedList<>();
                consistCharaterList.add(str);
                map.put(charToStr,consistCharaterList);
            }        
        }
        System.out.println(map);
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
        
    }
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> answer = groupAnagrams(strs);
        for(List<String> s : answer){
            System.out.println(s);
        }
    }
}
