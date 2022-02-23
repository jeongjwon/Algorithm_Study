class MyCircularQueue {
int[] cq ;
	int front = 0;
    int rear = 0;
    int size ;
	public MyCircularQueue(int k) {
        cq = new int[k+1];
        size = k+1;
    }
    
    public boolean enQueue(int value) {
    	if(isFull()) return false; //꽉 찼다면 false
//    	System.out.println("front : "+front + " rear : "+rear);
    	rear = (rear + 1) % size;
    	cq[rear] = value;
    	
    	return true; 
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;	//비어있다면 false
//        System.out.println("front : "+front + " rear : "+rear);
    	// cq[front] = -1;
        front = (front + 1) % size;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : cq[(front+1)%size] ;
    }
    
    public int Rear() {
        return isEmpty() ? -1 :cq[rear];
    }
    
    public boolean isEmpty() {
        return front == rear ? true: false;
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front ? true: false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
