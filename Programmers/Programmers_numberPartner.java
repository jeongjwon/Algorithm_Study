import java.util.*;

class Programmers_numberPartner {
    public static String solution(String X, String Y) {
        String answer="";
        //내 풀이 두 문자열에서 공통 수 찾기 => 배열 이용
        List<Character> duplicate = new ArrayList<>();
        char[] xArr = X.toCharArray();
        char[] yArr = Y.toCharArray();
    
        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int idxX = 0, idxY = 0;

        while(idxX < xArr.length && idxY < yArr.length){
            if(xArr[idxX] == yArr[idxY]){
                duplicate.add(xArr[idxX]);
                idxX++;
                idxY++;
            }else{
                if(xArr[idxX] < yArr[idxY]){
                    idxX++;
                }else{
                    idxY++;
                }
            }
        }
       
        Collections.sort(duplicate, Collections.reverseOrder());   
        
        StringBuilder sb = new StringBuilder();
        for(Character c : duplicate){
            sb.append(c);
        }
        answer = sb.toString();

        // if(answer.charAt(0)== '0') return("0");
        // else if(answer.equals("")) return("-1");
        // else return answer;


        //다른 사람의 풀이: 0~9까지의 숫자로 이루어져있으므로 각 문자열마다 숫자가 몇 개 있는지 확인
        int[] x = {0,0,0,0,0,0,0,0,0,0};
        int[] y = {0,0,0,0,0,0,0,0,0,0};

        for(int i = 0 ; i < X.length() ; i++){
            x[X.charAt(i)-48] += 1;
        }
        for(int i = 0 ; i < Y.length() ; i++){
            y[Y.charAt(i)-48] += 1;
        }
        sb = new StringBuilder();
        //큰수를 만들어야 하는 만큼 배열의 뒤에서부터
        //Math.min(x[i],y[i]) 각자 가지고 있는 수의 최소만큼 append 해줌
        for(int i = 9 ; i >= 0 ; i--){
            for(int j = 0 ; j < Math.min(x[i],y[i]) ; j++){
                sb.append(i);
            }
        }
        if("".equals(sb.toString())) return "-1";
        else if((sb.toString().charAt(0))-48 == 0) return "0";
        else return sb.toString();
        
        
    }
    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        System.out.println(solution(X,Y));
    }
}