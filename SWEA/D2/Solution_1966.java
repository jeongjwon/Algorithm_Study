

import java.util.*;

public class Solution_1966 {
    public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ;  i < n ; i++){
                arr[i] = sc.nextInt();
            }
            // Arrays.sort(arr);
            for(int i = 0 ; i < n ; i++){
                for(int j = i+1 ; j < n ; j++){
                    if(arr[i] > arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            
			System.out.print("#"+ test_case + " ");
            for(int a : arr) System.out.print(a+" ");
            System.out.println();
		}
        sc.close();
	}
}
