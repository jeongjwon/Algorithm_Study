import java.util.*;

class Programmers_wayToLine {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> number = new ArrayList<>();
        long fac = 1;
        for(int i = 1 ; i <= n ; i++){
            number.add(i);
            fac *= i;
        }
        
        int idx = 0;
        k--;
        
        while(idx < answer.length){
            fac /= (n--);
            int value = (int)(k/fac);
            answer[idx++] = number.get(value);
            number.remove(value);
            k %= fac;

        }
    
        
       

        return answer;
    }
    public static long factorial(int number){
        long answer= 1;

        while(number > 0){
            answer *= number;
            number--;
        }
       
        
        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        int[] res = solution(n,k);
        for(int r : res){
            System.out.println(r);
        }
    }
    
}
