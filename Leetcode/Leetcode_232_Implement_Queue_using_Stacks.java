import java.util.Stack;

class MyQueue {
    Stack<Integer> queue = new Stack<>();
    Stack<Integer> temp = new Stack<>();
   

    //push 1 // 1
    // push 2 // 1 2
    //peek 1 (맨 앞) // 1 2
    //pop 1 (맨 앞) // 2
    //empty false 
    //queue 1 2 
    //temp 3 2 1

    public MyQueue() {
        
    }
    
    public void push(int x) {
        //queue 2 1 -> 나가는 문
        //temp  
        while(!queue.isEmpty()){
            temp.push(queue.pop()); 
        }
        queue.push(x);
        while(!temp.isEmpty()){
            queue.push(temp.pop());
        }
        
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.empty();
    }
}
public class Leetcode_232_Implement_Queue_using_Stacks {
    public static void main(String[] args){
        
    }
}
