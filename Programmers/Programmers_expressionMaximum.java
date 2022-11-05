
import java.util.*;

class Programmers_expressionMaximum     {
    static long answer = Long.MIN_VALUE;
    static ArrayList<String> operation = new ArrayList<>(); //연산자 list
    static ArrayList<Long> number = new ArrayList<>(); //숫자 list
    static String[] opr = new String[] {"+","-","*"};
    static String[] result = new String[3];
    static boolean[] visited = new boolean[3];

    public static long solution(String expression) {
       

       //expression -> 연산자와 숫자 구분
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <expression.length() ; i++){
            char ch = expression.charAt(i);
            if(ch == '*' || ch=='-' || ch=='+' ){
                number.add(Long.parseLong(sb.toString()));
                operation.add(String.valueOf(ch));
                sb = new StringBuilder();
            }else{
                sb.append(ch);
                if(i == expression.length()-1){
                    number.add(Long.parseLong(sb.toString()));
                }
            }
        }
        
       //우선순위 정하기
       permutation(0,3,opr, visited, result);

        return answer;
    }
    public static void permutation(int r, int depth, String[] opr, boolean[] visited, String[] result){
        
        if(r == depth){
            solve();
            return;
        }else{
            for(int i = 0 ; i < opr.length ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    result[r] = opr[i];
                    permutation(r+1, depth, opr, visited, result);
                    visited[i] =false;
                }
            }
        }
    }
    public static void solve(){

        ArrayList<Long> num = new ArrayList<>();
        ArrayList<String> o = new ArrayList<>();
        num.addAll(number);
        o.addAll(operation);

        for(int i = 0 ; i < result.length; i++){
            String now = result[i];//현재 연산자
            for(int j= 0 ; j < o.size() ; j++){
                if(o.get(j).equals(now)){

                    long a = num.get(j);//연산자 전 숫자
                    long b = num.get(j+1);//연산자 후 숫자
                    long res = cal(a,b,now);
                    
                    num.remove(j+1);//뒤부터 먼저 삭제
                    num.remove(j);

                    o.remove(j);
                    
                    num.add(j, res);
                    j--;//숫자 두개를 지우고 하나를 추가했으니 하나 줄이기
                }
            }
        }
        // System.out.println(num);
        
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    public static long cal(long a, long b, String s){
        long res = 0;
        switch(s){
            case "+": res = a+b ; break;
            case "-": res = a-b; break;
            case "*": res = a*b; break;
        }
        return res;
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
