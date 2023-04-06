import java.util.*;
public class Leetcode_771_Jewels_and_Stones {
    public static int numJewelsInStones(String jewels, String stones) {
        //map 사용
        HashMap<Character, Integer> map = new HashMap<>();

        for(char stone : stones.toCharArray()){
            map.put(stone, map.getOrDefault(stone, 0)+1);
        }
        int count = 0;
        for(char jewel : jewels.toCharArray()){
            if(map.containsKey(jewel)){
                count += map.get(jewel);
            }
        }
        //배열 사용
        for(char stone : stones.toCharArray()){
            if(jewels.indexOf(stone) != -1) count++;
        }
        return count;
    }
    public static void main(String[] args){
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }
}
