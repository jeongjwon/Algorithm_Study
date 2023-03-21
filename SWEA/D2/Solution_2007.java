
import java.util.Scanner;



class Solution_2007
{
	
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = sc.next();
			
			for(int i = 1 ; i < 10 ; i++){

				String s1 = str.substring(0, i);
				String s2 = str.substring(i, i+i);

				if(s1.equals(s2)){
					
					System.out.println("#"+test_case+ " "+ s1.length());
					break;
				}
			}
			
			
		}
		sc.close();
	}
}
