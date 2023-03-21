import java.util.*;

class exaSolution_1954mple
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] snail = new int[n][n];

            int num = 1;
            int input = n;
            int right = 0, bottom = -1 , top = 1;

            for(int i = n ; i > 0 ; i++){
                
                for(int j = 0 ; j < input ; j++){
                    bottom = bottom + top;
                    snail[right][bottom] = num++;

                }
                input--;
                for(int j = 0 ; j < input ; j++){
                    right = right + top;
                    snail[right][bottom] = num++;
                }
                top *= -1;
            }
            // int i = 0 , j=0;
            // int w = n;
            // int h = n-1;
            // while(num <= n*n){
            //     for(int k = 0 ; k < w ; k++){
            //         snail[i][j++] = num++;
            //     }w--;i++; j--;

            //     for(int k = 0 ; k < h ; k++){
            //         snail[i++][j] = num++;
            //     }h--;i--;j--;
                
            //     for(int k = 0 ; k < w ; k++){
            //         snail[i][j--] = num++;
            //     }w--;i--;j++;

            //     for(int k = 0 ; k < h ; k++){
            //         snail[i--][j] = num++;
            //     }h--;i++;j++;
            // }

            


            System.out.println("#"+test_case+ " ");
            for(int a = 0 ; a < n ; a++){
                for(int b = 0 ;b < n ; b++){
                    System.out.print(snail[a][b] + " ");
                }
                System.out.println();
            }

		

			
		}
        sc.close();
	}
}

