public class Leetcode_739_DailyTemperatures {
       public static int[] dailyTemperatures(int[] temperatures) {
    	
    	int n = temperatures.length;
    	int[] answer = new int[n];
    	Arrays.fill(answer, 0);
           
        Stack<Integer> stack = new Stack<>(); //value대신 index 투입
    	
        //O(n^2)
//     	for(int i = 0 ; i < temperatures.length ; i++) {
//     		for(int j = i+1 ; j < temperatures.length ; j++) {
//     			if(temperatures[i] < temperatures[j]) {answer[i] = j-i; break;}
    			
//     		}
//     	}
    	
    	for(int i = 0 ; i < n ; i++) {
    		while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
    			int idx = stack.pop();
    			answer[idx] = i-idx;
    		}
    		stack.push(i);
    	}

    	

    
    	return answer;
    }
}
