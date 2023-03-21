import java.util.*;
//내가 푼 방식 : List
class MyQueue{
	Stack<Integer> stack = new Stack<>();
	List<Integer> s_list = new ArrayList<>();

	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();
	
	 public void push(int x) {
		 stack.push(x);
		 s_list.add(x);

		 input.push(x);
	 
	 }
	    
	 public int pop() {
		 int value = s_list.remove(0);
	     return value;
	     
	 }
	    
	 public int peek() {
		 
		 return s_list.get(0);
	 }
	    
	 public boolean empty() {
	     return s_list.size() == 0 ? true : false;
	 }
	 


//정답 코드 : Stack 두 개를 이용
Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	//stack1 1 2 3 4   (top)  -> real
	//stack2 4 3 2 1  (top) -> temporary
	// public void push(int x) {
	// 	while(!stack1.isEmpty()) {
	// 		stack2.push(stack1.pop());
	// 	}
	// 	stack1.push(x);
	// 	while(!stack2.isEmpty()) {
	// 		stack1.push(stack2.pop());
	// 	}
		
	// }
	// public int pop() {
	// 	int value = stack1.pop();
	// 	return value;
	// }
	// public int peek() {
	// 	return stack1.peek();
	// }
	// public boolean empty() {
	// 	return stack1.isEmpty();
	// }
}

// 살짝 어려움 
// class MyQueue {

//     Stack<Integer> input = new Stack();
//     Stack<Integer> output = new Stack();
    
//     public void push(int x) {
//         input.push(x);
//     }

//     public void pop() {
//         peek(); //여기서 출력
//         output.pop();
//     }

//     public int peek() {
//         if (output.empty())
//             while (!input.empty())
//                 output.push(input.pop());
//         return output.peek();
//     }

//     public boolean empty() {
//         return input.empty() && output.empty();
//     }
// }
