import java.util.*;
public class Leetcode_937_ReorderDataInLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        // 그 뒤의 문자열은 letter은 숫자를 제외한 문자 , git은 문자를 제외한 숫자
        //순서 정렬
        //letter 먼저 digit
        //letter 은 알파벳 순서대로
        //digt 은 원래 순서대로

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for(int i = 0 ; i < logs.length ; i++){

            String[] arr = logs[i].split(" ");
            int idx = logs[i].indexOf(" ");
            
            if((arr[1].charAt(0) >= 'a' && arr[1].charAt(0) <= 'z') || 
            (arr[1].charAt(0) >= 'A' && arr[1].charAt(0) <= 'Z'))  {
               letters.add(logs[i]);               
            }else{
                digits.add(logs[i]);
            }
        }
         //letters 정렬
         Collections.sort(letters, new Comparator<String>(){
            public int compare(String s1, String s2){
                String c1 = s1.substring(s1.indexOf(" ") + 1);
                String c2 = s2.substring(s2.indexOf(" ") + 1);
               if(c1.equals(c2)) return s1.compareTo(s2);
                else return c1.compareTo(c2);
            }
         });
       
        String[] result = new String[logs.length];
 
        for(int i = 0 ; i < letters.size() ; i++){
            result[i] = letters.get(i);
        }
        for(int i = 0 ; i < digits.size() ; i++){
            result[i+letters.size()] = digits.get(i);
        }
        

        
        return result;
    }
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] res = reorderLogFiles(logs);
        System.out.println();
        for(String r : res)  System.out.println(r);
    }
}