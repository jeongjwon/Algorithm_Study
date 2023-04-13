import java.util.*;
public class Leetcode_17_Letter_Combinations_of_a_Phone_Number {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, List<Character>> numbers = new HashMap<>();
        
        char[] symbols = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'};
        String[] letters = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "+", " ", "#"};

        for(int i = 0 ; i < symbols.length ; i++){

            char[] chars = letters[i].toCharArray();
            List<Character> list = new ArrayList<>();
            for(char c : chars) list.add(c);
            numbers.put(symbols[i], list );
        }

        System.out.println(numbers);

        for(char c : digits.toCharArray()){
            int n = numbers.get(c).size();
            Character[] chars = numbers.get(c).toArray(new Character[n]);
            boolean[] visited = new boolean[n];
            
        }
        return result;
    }
    public static void main(String[] args){
        String digits = "23";
        List<String> result = letterCombinations(digits);
    }
}
