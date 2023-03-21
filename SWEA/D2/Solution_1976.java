
import java.util.Scanner;


class Solution_1976
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
		
            int h = h1 + h2 ; 
            int m = m1 + m2 ;

            if(m >= 60){
                h += (m / 60);
                m %= 60;
            }
            if(h > 12){
                if(h % 12 == 0){
                    h = 12;
                }
                else{
                    h %= 12;
                }
            }
            
            
             
			System.out.println("#"+ test_case + " "+h + " " +m);
		}
        sc.close();
	}
}

