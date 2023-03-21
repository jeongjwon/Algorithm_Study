import java.util.*;

class Solution_1946
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                char c = sc.next().charAt(0);
                
                
                int times = sc.nextInt();
                
                for(int j = 0 ; j < times ; j++){
                    sb.append(c);
                }
                
            }
            System.out.println(sb);
            String res = sb.toString(); 
            System.out.println("#"+test_case);

            for(int i = 0 ; i < res.length() / 10 ; i++){
                System.out.println(res.substring(i*10, i*10+10));
            }
            System.out.println(res.substring(res.length()/10 * 10));

			
		}
        sc.close();
	}
}

