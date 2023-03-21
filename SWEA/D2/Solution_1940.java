import java.util.*;

class Solution_1940
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int dis = 0;
            int speed = 0;
            int prev = 0;

            for(int i = 0 ; i < n ; i++){
                int command = sc.nextInt();

                if(command == 1){
                    speed = sc.nextInt();
                    prev += speed;
                }else if(command == 2){
                    speed = sc.nextInt();
                    prev -= speed;
                    if(prev < 0) prev = 0;
                    //최소 속도가 0임을 주의!
                }
               
                dis+=prev;

                   
                    
                    
                
            }
            System.out.println("#"+test_case+" "+dis);
// 2 + 1 = 3
// 1 + 1 + 2 = 4
// 2 + 4 + 3 + 3 + 3  =15 
			
		}
        sc.close();
	}
}

