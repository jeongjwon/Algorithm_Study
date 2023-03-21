import java.util.*;

class Solution_1244 {
    static int res = 0;
    public static void dfs(int start, int count, String[] target){
        String temp ;
        
        
        if(count == 0){
            StringBuilder sb = new StringBuilder();
            for(String t: target){
                sb.append(t);
            }
            int cur = Integer.parseInt(sb.toString());
           System.out.println(cur);
            if(cur > res){
                res = cur;
            }
            return;
        }

        for(int i = start ; i < target.length ; i++){
            for(int j = i+1 ; j < target.length ; j++){

                    //swap
                    temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                    //바꾼 값에서 다시 재귀
                    dfs(i, count-1, target);

                    //다시 swap 하여 제자리
                    temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;


                
            }
        }
        
        
    }

    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();
       
        

        for (int test_case = 1; test_case <= T; test_case++) {

            int number = sc.nextInt();
            int chance = sc.nextInt();
            
            String[] target = Integer.toString(number).split("");
            // DFS 깊이 우선 탐색 : 모든 경우의 수를 탐색하고 올라옴
            res = 0;
            if(target.length < chance) chance = target.length;
            dfs(0,chance, target);

           
            
            System.out.println("#" + test_case + " " + res);
            
            
            

        }
        sc.close();
    }
}






 
