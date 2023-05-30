import java.util.*;

public class Leetcode_242_Valid_Anagram {
    
    public static boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;

        boolean result = false;
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(char c: s.toCharArray()){
            mapS.put(c, mapS.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){

            if(!mapS.containsKey(c)) return false;
            else{
                int newCount = mapS.get(c) - 1;
                if(newCount == 0) mapS.remove(c);
                else mapS.put(c, newCount);
            }
        }

        // System.out.println(mapS);


        return mapS.isEmpty() ? true: false;

        
    }
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));
    }
}
