import java.util.*;
public class Leetcode_49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> answer = new ArrayList<>();
    	if(strs == null || strs.length == 0) return new ArrayList<>();
    	//먼저 걸려야할 것은 null이거나 비어있는 strs 경우
    	
    	Map<String , List<String>> map = new HashMap<>();
    	
    	for(String s : strs) {
    		char[] temp = s.toCharArray();
    		Arrays.sort(temp);
    		String key = String.valueOf(temp);
    		//key에 넣을 값 : 오름차순으로 정렬한 문장
    		if(!map.containsKey(key)) map.put(key, new ArrayList<>());
    		//key가 있다면 배열 안에 있던 그대로의 문장을 key의 value로 추가
    		map.get(key).add(s);
    	}
    	System.out.println(map);
    	//key : 가지고 있는 알파벳을 오름차순으로 정렬한 값
    	//value : 그 key들을 가지고 있는 strs배열 안의 값

    	return new ArrayList<>(map.values());
    	//map의 value들을 List로 변형한 값
    }
}
