import java.util.Arrays;
import java.util.HashMap;

public class Programmers_mobile_list {
    public static boolean solution(String[] phone_book){
        boolean answer = true;
       
        //1 . Loop -> substring 대신 startsWith 이용
        Arrays.sort(phone_book);
        for(int i = 0  ; i < phone_book.length - 1 ; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }


        //2. HashMap 이용 
        //모든 전화번호 값을 넣고
        //이중 포문으로 그 접두어의 길이만큼 contains 되어있는지 비교
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s : phone_book) hm.put(s, 1);

        for(int i = 0 ; i < phone_book.length ; i++){
            for(int j = 0 ; j < phone_book[i].length() ; j++){
                if(hm.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }

       

        return answer;
    }
    public static void main(String[] args){
        String[] phone_book = { "119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
