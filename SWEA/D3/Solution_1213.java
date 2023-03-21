import java.util.*;

class Solution_1213 {

    public static void main(String args[])throws Exception {

        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
           
            int n = sc.nextInt();
            String find = sc.next();
            String str = sc.next();

            int cnt =0; 
            
            for(int i = 0 ; i < str.length() ; i++){
                String s = "";
                if(i+find.length() < str.length()){ // 글자수가 find.length()보다 작다는 말
                    s = str.substring(i);
                }
                else{
                    s = str.substring(i, i+find.length());
                }
                
                if(find.equals(s)){
                    cnt++;
                }
            }
            // i의 범위 수정 : 어차피 i+find.length()는 비교불가임
            for(int i = 0 ; i <= str.length()-find.length() ; i++){
                String s = str.substring(i, i+find.length());
                if(find.equals(s)) cnt++;
            }
            System.out.println("#"+n + " "+cnt);

        }
        sc.close();
    }
}
