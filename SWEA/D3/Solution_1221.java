import java.util.*;

class Solution_1221 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = sc.nextInt();
        String[] number = {"ZRO",  "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            int n = sc.nextInt();
            String[] arr = new String[n];
            int[] temp = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.next();
                for(int j = 0 ; j < number.length ; j++){
                    if(arr[i].equals(number[j])){
                        temp[i] = j;
                    }
                }   
            }
            Arrays.sort(temp);
            System.out.println("#"+test_case);
            for(int i = 0 ; i < n ; i++){
                int num = temp[i];
                System.out.print(number[num]+" ");
            }
            

          
           
            

        }
        sc.close();
    }
}
