import java.util.*;

class Solution_1928
{
	
	
	public static void main(String args[]) throws Exception
	{
		
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String encode = sc.next();
            String decode = new String(Base64.getDecoder().decode(encode));

            System.out.println("#"+test_case+" "+decode);
            
			
		}
		sc.close();
	}
}

//TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u = Encoding 
//TGl mZS Bpd HNl bGY gaX MgY SBx dW9 0YX Rpb 24u
// 
//Life itself is a quiotation. = Decoding