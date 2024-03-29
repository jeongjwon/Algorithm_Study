import java.util.*;
public class Leetcode_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
    	
    	Map<Character, Integer> map = new HashMap<>();
    	for(int i = 0 ; i < s.length(); i++) {
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
    	}
    	for(int i = 0 ; i < t.length() ; i++) {
    		if(map.containsKey(t.charAt(i))) {
    			map.compute(t.charAt(i), (c, integer) -> (integer-1 == 0) ? null : integer-1);
    		}
    	}
    	return map.isEmpty() ? true : false;
    }
}
