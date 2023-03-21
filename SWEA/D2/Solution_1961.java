

import java.util.*;

class Solution_1961
{
    public static int[][] rotate(int[][] arr){
        int n = arr.length;
        int[][] res = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = n-1 ; j>= 0 ; j--){
                res[i][n-j-1] = arr[j][i];
            }
            
        }
        return res;
    }
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] first = rotate(arr);
            int[][] second = rotate(first);
            int[][] third = rotate(second);

           
            System.out.println("#"+ test_case + " ");
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(first[i][j]);
                }
                System.out.print(" ");
                for(int j = 0 ; j < n ; j++){
                    System.out.print(second[i][j]);
                }
                System.out.print(" ");
                for(int j = 0 ; j < n ; j++){
                    System.out.print(third[i][j]);
                }
                System.out.println();
            }
		}
        sc.close();
	}
}

