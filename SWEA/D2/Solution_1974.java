
import java.util.Scanner;



class Solution_1974
{
    
    
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] arr = new int[9][9];

			for(int i = 0 ; i < 9 ; i++){
				for(int j = 0 ; j < 9 ; j++){
					arr[i][j] = sc.nextInt();
				}
			}

			int flag = 1;

			//row
			for(int i = 0 ; i < 9; i++){
				// int[] row = new int[9];
				// int[] col = new int[9];
				int sumR = 0, sumC = 0;

				for(int j = 0 ; j < 9 ; j++){
					sumR += arr[i][j];
					sumC += arr[j][i];
					
					// row[arr[i][j]-1]++;
					// col[arr[i][j]-1]++;
				}
				if(sumR != 45 || sumC != 45){
					flag = 0;
					break;
				}
				// for(int idx = 0 ; idx < 9 ; idx++){
				// 	if(row[idx] == 0 || cow[idx] = 0) {
				// 		flag = 0;
				// 		break;
				// 	}
				// }

			}

			if(flag == 0){
				System.out.println("#"+ test_case + " "+flag);
				continue;
			}

			//box 
			for(int i = 0 ; i < 9 ; i+=3){
				for(int j = 0 ; j < 9 ; j+=3){
					// int[] box = new int[9];
					int sum = 0;
					for(int a = 0 ; a < 3 ; a++){
						for(int b = 0 ; b < 3; b++){
							sum += arr[i+a][j+b];
							// box[arr[i+a][j+b]-1]++;
						}
					}
					// for(int z = 0 ; z < 9 ; z++){
					// 	if(box[z] == 0){
					// 		flag = 0;
					// 		break;
					// 	}
					// }
					if(sum != 45){
						flag = 0;
						break;
					}
				}
				if(flag == 0) break;
			}
			System.out.println("#"+ test_case + " "+flag);
		}
		sc.close();
	}
}

