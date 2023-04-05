import java.util.*;
class MyCircularQueue {
    int[] cirQueue ;
    LinkedList<Integer> queue;
    int size ;
    int front = 0, rear = 0;

    public MyCircularQueue(int k) {
        cirQueue = new int[k+1];
        queue = new LinkedList<>();
        size = k+1;
    }
    
    public boolean enQueue(int value) {
        // if(size == queue.size()) return false;
        // queue.add(value);
        // return true;
        if(isFull()) return false;
        rear = (rear + 1) % size;
        System.out.println("rear:"+rear);
        cirQueue[rear] = value;
        return true;
    }
    public boolean deQueue() {
        //앞에서 빼기
        
        // if(queue.size() <= 0) return false;
        // queue.remove(0);
        // return true;
        
        if(isEmpty()) return false;
        front = (front + 1) % size;
        return true;
        
    }
    
    public int Front() {
        // return queue.get(0);
        return isEmpty() ? -1 : cirQueue[(front+1)%size];
    }
    
    public int Rear() {
        // return queue.get(queue.size()-1);
        return isEmpty() ? -1 :cirQueue[rear];
    }
    
    public boolean isEmpty() {
        // return queue.size() == 0;
        return front == rear ? true : false;
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front ? true : false;
    }
}
public class Leetcode_622_Design_Circular_Queue {
    public static void main(String[] args){
        // LinkedList<Integer> list = new LinkedList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // System.out.println(list.remove(0));

        // for(int i = 0 ; i < list.size() ; i++){
        //     System.out.println("i :"+i + "  " + list.get(i));
        // }
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();  
    }
   

}
