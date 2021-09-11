package DataStructure.Stack;

public class DS_Array_Stack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.peek());
        arrayStack.showStack();
        arrayStack.pop();
        arrayStack.showStack();

    }
}

class ArrayStack{
    private int top = -1;
    private int maxSize;
    private int[] stack = null;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];

    }

    public boolean isEmpty(){
        return  top == -1;
    }

    public boolean isFull(){
        return  top == this.maxSize-1;
    }

    public void push(int num){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int ret = stack[top];
        top--;
        return ret;
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.printf("Stack(top to bottom) %d \n", stack[i]);
        }
    }

    public int peek(){
        return stack[top];
    }


}