class MyCircularDeque {
    int[] cirDeque;
    int front, rear, size;
    public MyCircularDeque(int k) {
        cirDeque = new int[k];
        size = k;      
        front = -1;
        rear = -1;  
    }
    //인덱스 이동 후 추가
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()) {
            front = 0;
            rear = size-1;
        }

        front = (front-1+size)%size;
        cirDeque[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;

        if(isEmpty()) {
            front = 0;
            rear = size-1;
        }

        rear = (rear+1) % size;
        cirDeque[rear] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        
        if(front == rear){
            front = -1;
            rear = -1;
        }else{
            front = (front+1+size)%size;
        }
        
        return true;

    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

         if(front == rear){
            front = -1;
            rear = -1;
        }else{
            rear = (rear-1+size) % size;
        }
        return true;
    }
    
    public int getFront() {
        
        return isEmpty() ? -1 : cirDeque[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : cirDeque[rear];
    }
    
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    
    public boolean isFull() {
        return (front-1+size)%size == rear;
    }
}

public class Leetcode_641_Design_Circular_Deque {
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
