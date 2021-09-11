package DataStructure.Queue;

public class DS_Array_Queue {
    private int max_size;
    private int[] queue;
    private int front;
    private int rear;

     public void arrayQueue(int arrMaxSize){
        max_size = arrMaxSize;
        queue = new int[max_size];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
         return rear == max_size-1;
    }

    public boolean isEmpty(){
         return rear == front;
    }

    public void addQueue(int num){
        if(isFull()){
            System.out.println("Queue is full");
        }
        rear++;
        queue[rear] = num;
    }

    public int getQueue(){
        if(isEmpty()){
           throw new RuntimeException("queue is empty");
        }
        front++;
        return queue[front];
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return queue[front+1];
    }

    public void showQueue(){
         if(isEmpty()){
             System.out.println("queue is empty");
             return;
         }

         for (int i = 0; i < queue.length; i++ ){
             System.out.println(queue[i]+ " ");
         }
    }

    public static void main(String[] args) {
        DS_Array_Queue queue1 = new DS_Array_Queue();
        queue1.arrayQueue(5);
        queue1.addQueue(5);
        queue1.addQueue(7);
        System.out.println(queue1.headQueue());
        queue1.showQueue();
    }
}


