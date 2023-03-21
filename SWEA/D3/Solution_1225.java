import java.util.*;

class Solution_1225 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0 ; i < 8 ; i++){
                queue.add(sc.nextInt());
            }
            boolean flag = true;

            while(flag){
                for(int i = 1 ; i <= 5; i++){
                    int peek = queue.poll();
                    if(peek-i <= 0){
                        queue.add(0);
                        flag = false;
                        break;
                    }else{
                        queue.add(peek-i);
                    }
                   
                    
                }
                
            }
            System
                .out
                .println("#" + test_case + " " );

            while(!queue.isEmpty()){
                System.out.print(queue.poll()+" ");
            }
            

        }
        sc.close();
    }
}
