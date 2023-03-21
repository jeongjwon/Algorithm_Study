

import java.util.*;

class Solution_1970
{
    public static int[] type = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int money = sc.nextInt();

			System.out.println("#"+ test_case + " ");
            for(int i = 0 ; i < type.length ; i++){
                int[] change = new int[type.length];
                if(money/type[i] > 0){
                    System.out.print(money/type[i] + " ");
                    money %= type[i];
                }else{
                    System.out.print(money/type[i] + " ");
                }
            }
            System.out.println();
		}
        sc.close();
	}
}

