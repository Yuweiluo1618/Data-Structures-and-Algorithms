package DataStructure.Queue;

public class DS_Circle_Array_Queue {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        System.out.println(queue.getQueue());
        queue.addQueue(6);
        System.out.println(queue.getQueue());
        queue.addQueue(7);
        queue.showQueue();
        System.out.println(queue.getHead());
    }
}

class CircleQueue{
    private int max_size;
    private int[] queue;
    private int front;
    private int rear;

    public CircleQueue(int queueMaxSize){
        max_size = queueMaxSize;
        queue = new int[max_size];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear+1)%max_size == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public int queueSize(){
        return (rear+max_size-front) % max_size;
    }

    public void addQueue(int num){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        queue[rear] = num;
        rear = ++rear % max_size;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        int ret = queue[front];
        front = ++front % max_size;
        return ret;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("queue is empty");
        }
        for (int i = front; i < front+queueSize(); i++){
            System.out.printf("index: %d, value: %d\n", i % max_size, queue[i%max_size]);
        }
    }

    public int getHead(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }

        return queue[front];
    }
}
