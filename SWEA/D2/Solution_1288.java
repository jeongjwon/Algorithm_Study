import java.util.*;

class Solution_1288
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
           
            ArrayList<Character> list = new ArrayList<>();
            int num = 0;
            int idx = 1;

            while(list.size() < 10){
                num = n * idx++;
               
                String s = String.valueOf(num);
                for(int i = 0 ; i < s.length(); i++){
                    if(!list.contains(s.charAt(i))){
                        list.add(s.charAt(i));
                    }
                }
            }
            idx -=1;
            System.out.println("#"+test_case+" "+idx * n);
           




			
		}
        sc.close();
	}
}

