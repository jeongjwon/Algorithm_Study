import java.util.*;

public class Programmers_saleEvent {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> list = new HashMap<>();
        //사고싶은 항목, 인덱스
        for(int i = 0 ; i < want.length ; i++){
            list.put(want[i], i);
        }
        
        int total = 0; //총 사야할 항목의 개수 => 즉 연속일수
        for(int n : number){
            total += n;
        }
        
        int idx1 = 0;
        int idx2 = total-1;
        
        int[] menu = new int[number.length];//바뀌는 날마다의 메뉴 변경사항
        for(int i = 0 ; i <total ; i++){
            if(list.containsKey(discount[i])){
                menu[list.get(discount[i])]++;
            }
        }
        
        while(true){
            if(check(number, menu)){
                answer++;
            }//idx1 ~ idx2 사이의 갯수들이 맞아 떨어진다면 가능한 수 ++
            
            if(list.containsKey(discount[idx1])){
                menu[list.get(discount[idx1])]--;
            }//idx1을 올려줘야하기 때문에 그 전의 값은 감소시켜줌
            
            idx1++;
            idx2++;
            
            if(idx2 == discount.length){
                break;
            }
            if(list.containsKey(discount[idx2])){
                menu[list.get(discount[idx2])]++;
            }//다음 idx2를 올려주었기 때문에 추가해줌
        }
        return answer;
    }

    public static boolean check(int[] number, int[] saleNum) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > saleNum[i]) {
                return false;
            }
            // System.out.print(saleNum[i] + " ");
        }
        // System.out.println();
        return true;
    }

    public static void main(String[] args) {
        String[] want = { "banana", "apple", "rice", "pork", "pot" };
        int[] number = { 3, 2, 2, 2, 1 };
        String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        System.out.println(solution(want, number, discount));
    }

}
