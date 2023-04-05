import java.util.*;

class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.add(x);
        //1 2 3
        //넣는 값을 앞으로
        
    }
    
    public int pop() {
        //push 1   => 1
        //push 2   => 1 2
        //top => 2
        int size = queue.size();
        for(int i = 0 ; i < size-1; i++){
            queue.add(queue.poll());
        }
        int value = queue.poll();
        return value;
    }
    
    public int top() {
        int size = queue.size();
        for(int i = 0 ; i < size-1; i++){
            queue.add(queue.poll());
        }
        int value = queue.poll();
        queue.add(value);
        return value;
        
    }
    
    public boolean empty() {
        return queue.isEmpty();
        
    }
}
public class Leetcode_225_Implement_Stack_using_Queues {
    
}
