import java.util.*;

class Solution_1234 {


    public static void main(String args[])throws Exception {
       
        
        Scanner sc = new Scanner(System. in);
        int T;
        T = 1;

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            String s = sc.next();

            int i = 0;
            
            while(i+1 < n && i >= 0){
            //    System.out.println(n + " " + s);
                if(s.charAt(i) == s.charAt(i+1)){
                    //연속된 두자리가 같은 부분을 찾는다
                    int idx = 1;

                    while(i+1+idx < n && i-idx>=0){
                        //찾은 부분의 전후 문자가 다를 떄까지 비교한다    
                        if(s.charAt(i-idx) == s.charAt(i+1+idx)){
                            // char c1 = s.charAt(i-idx);
                            // char c2 = s.charAt(i+idx+1);
                            // System.out.println(c1+"vs"+c2);
                            idx++;
                        }
                        else{
                            // System.out.println("다를 때까지의 idx : "+idx);
                            break;
                        }
                        
                    }
                    //idx 를 가지고 s 를 갱신시킨다.
                    if(i + idx + 1 >= n){
                        s = s.substring(0, i-idx+1);
                    }else{
                        s = s.substring(0 , i - idx+1) + s.substring(i + idx+1);
                    }
                    
                    n = s.length();
                    i = 0;
                    // System.out.println("-> " + n +" "+ s);
                    // System.out.println();

                }else{
                    i++;
                }
            }
            System
                .out
                .println("#" + test_case + " " +s);
        

        }
        sc.close();
    }
}

//16 4100112380990844 -> 12 412380990844
//12 41238099084 -> 