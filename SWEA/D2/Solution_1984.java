


import java.util.Scanner;


class Solution_1984
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] arr = new int[10];
            int max = 0, min = 10000;
            double sum = 0;

            for(int i = 0 ; i < 10 ; i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
                sum += arr[i];

            }
            
            sum -= max;
            sum -= min;
            sum /= 8;
            int res = (int)Math.round(sum);
            System.out.println("#"+ test_case + " "+ res);
            
		}
        sc.close();
	}
}