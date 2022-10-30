import java.util.*;

class Programmers_bracketChange {
    public static String solution(String p){
        String answer = dfs(p);
        return answer;
    }
    public static String dfs(String p) {
        String result = "";

        //1. 빈 문자열일 경우, 빈 문자열 반환
        if(p.length() == 0){
            return "";
        }

        int len = p.length();
        int index = 0;
        
        int left = 0 , right = 0;

        //1차 분리 -> 균형 잡혔는지 확인
        while(index < len){
            char c = p.charAt(index++);
            if(c == '(') left++;
            else right++;
            if(left == right) break;
        }
        
        String u = p.substring(0,index); //균형 잡힌 = 그냥 갯수 같을 거
        String v = p.substring(index,len); //올바른 = 짝이 같아야 함

        System.out.println(" u : "+u +"   v : "+ v);

        //균형잡힌 > 올바른

        //균형잡힌 u가 올바른인지에 대한 유무

        if(isAlright(u)){
            //올바른 문자열이라면 문자열 v 에 대한 재귀적 수행
            result = u + dfs(v);
        }else{
            //올바른 문자열이 아니라면 양끝에 ()를 추가하고 v를 재귀적 수행
            result = "(" + dfs(v) + ")";
            System.out.println("result : "+result);
            //u의 첫문자와 마지막문자를 제거하고 괄호방향 반대로 해서 result에 추가
            String tmp = u.substring(1, u.length()-1);
            tmp = tmp.replace("(", ".");
            tmp = tmp.replace(")", "(");
            tmp = tmp.replace(".", ")");
            result += tmp;
        }
       
        return result;
    
        
    }
    public static boolean isAlright(String p){
        //올바른 문자열인지에 대한 유무 -> stack이 비었다면 올바름
        Stack<Character> stack = new Stack<>();
        for(char c : p.toCharArray()){
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                else{
                    stack.pop();
                }
            }
        }       
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        // String p = ")(";
        String p = "()))((()";
        System.out.println(solution(p));
    }
}
// u = () -> 올바른 문자 -> result = () +dfs(v) = ()(())()
// v = ))((()
//     -> u = ))(( -> 올바른 문자 x -> result = ( + dfs(v) + ) = (()) + () = (())()
//         v = ()
//         -> u = ()올바른 문자 -> result = () + dfs("")
