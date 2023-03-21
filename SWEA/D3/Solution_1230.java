import java.util.*;

public class Solution_1230 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
           
            List<Integer> code = new LinkedList<>();

            for(int i = 0 ; i < n ; i++){
                code.add(sc.nextInt());
            }

            int order = sc.nextInt();
            
            for(int i = 0 ; i < order ; i++){
                //I x y s
                //D x y
                String str = sc.next();
               
                if(str.equals("I")){
                    //추가
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for(int j = 0 ; j < y ; j++){
                        code.add(x+j, sc.nextInt());
                    }
                }else if(str.equals("D")){
                    //삭제
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for(int j = 0 ; j < y ; j++){
                        code.remove(x);
                    }
                }else{
                    int y = sc.nextInt();
                    for(int j = 0 ; j < y ; j++){
                        code.add(sc.nextInt());
                    }
                }

            }
            System
                .out
                .println("#" + test_case + " " );
           for(int i = 0 ; i < 10 ; i++){
                System.out.print(code.get(i)+ " ");
            }
        }
        sc.close();
    }
}
