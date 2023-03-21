

import java.util.Scanner;


class Solution_1959
{
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            
            int[] a = new int[l1];
            int[] b = new int[l2];

            for(int i = 0 ; i < l1 ; i++){
                a[i] = sc.nextInt();
            }

            for(int i = 0 ; i < l2 ; i++){
                b[i] = sc.nextInt();
            }

           
            int ans = Integer.MIN_VALUE;

            if(l1 < l2){
                int[] arr = new int[l2-l1+1];
                for(int i = 0 ; i < l2-l1+1; i++){ //15-5+1 0~11
                    int sum = 0;
                    for(int j = 0 ; j < l1; j++){ // 0~4
                        sum += a[j] * b[i+j];
                        //System.out.print(a[j] + " * " + b[i+j] + " + ");
                    }
                    arr[i] = sum;
                    //System.out.println(arr[i]);
                    ans = Math.max(ans, arr[i]);
                }
            }else{
                int[] arr = new int[l1-l2+1];
                for(int i = 0 ; i < l1-l2+1; i++){
                    int sum = 0;
                    for(int j = 0 ; j < l2  ; j++){
                        //System.out.print(a[i+j] + " * " + b[j] + " + ");
                        sum += b[j] * a[i+j];
                    }
                    arr[i] = sum;
                    //System.out.println(arr[i]);
                    ans = Math.max(ans, arr[i]);
                }
            }
			System.out.println("#"+ test_case + " " + ans);
		}
        sc.close();
	}
}
// 0 1 2 3 4 
// 5 6 7 8 9

