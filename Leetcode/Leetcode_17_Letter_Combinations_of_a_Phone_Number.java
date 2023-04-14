import java.util.*;
public class Leetcode_17_Letter_Combinations_of_a_Phone_Number {
    public static void backtracking( List<String> result, String digits, HashMap<Character, String> numbers, String str, int index){
        if(index == digits.length()){
            result.add(str);
            return;
        }
        char c = digits.charAt(index);
        String letters =  numbers.get(c);

        //"23"
       //["ad","ae","af","bd","be","bf","cd","ce","cf"]
       
       //letters = "abc"; / "def"
       //index 0 1
       //      a d 
       //        e
       //        f
        //         b d

        for(int i = 0; i < letters.length(); i++){
            System.out.println(str+letters.charAt(i));
            backtracking(result, digits, numbers,str+letters.charAt(i), index+1);

        }

    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> numbers = new HashMap<>();
        
        
        char[] symbols = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'};
        String[] letters = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "+", " ", "#"};


        for(int i = 0 ; i < symbols.length ; i++){
            char[] chars = letters[i].toCharArray();
            numbers.put(symbols[i], letters[i] );
        }
        System.out.println(numbers);
        backtracking(result, digits, numbers ,"" ,0);
        
        
        return result;
    }
    public static void main(String[] args){
        String digits = "23";
        List<String> result = letterCombinations(digits);
    }
}
