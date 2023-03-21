

import java.util.Scanner;

class Solution_1989
{
	public static void main(String args[]) throws Exception
	{
	
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
            String str = sc.next();

            
            
            int n = str.length()-1;
            int flag = 1;
            for(int i = 0 ; i < str.length()/2 ; i++){
                if(str.charAt(i) != str.charAt(n-i)){
                    flag = 0;
                    break;
                }
                
            }
           
            
                System.out.println("#"+test_case + " "+flag);
            
		}
        sc.close();
	}
}