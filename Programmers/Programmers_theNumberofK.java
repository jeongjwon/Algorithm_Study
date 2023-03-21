import java.nio.charset.CharacterCodingException;
import java.util.*;

class theNumberofK {
    public static int solution(int i, int j, int k) {
        int answer = 0;
        
        // for(int idx = i ; idx <= j ;idx++){

        //     String temp = String.valueOf(idx);
        //     if(temp.contains(String.valueOf(k))){
        //         System.out.println(temp);
        //         char[] c = temp.toCharArray();
        //         for(char ch : c){
        //             if(String.valueOf(ch).equals(String.valueOf(k))){
                        
        //                 answer++;
        //             }
        //         }
        //     }
            
        // }

        for(int idx = i ; idx<=j ; idx++){
            String temp = String.valueOf(idx);
            for(int l = 0 ; l < temp.length() ; l++){
                if(temp.charAt(l)-'0' == k) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(1,13,1));

    }
}