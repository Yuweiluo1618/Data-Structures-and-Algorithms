package DataStructure.Stack;

public class DS_Reverse_Polish_Notation_Calculator_1 {
    public static void main(String[] args) {
        ArrayStack3 numStack = new ArrayStack3(20);
        String expression = "34+5*6-";
        int index = 0;
        char ch;
        while (true){
            ch = expression.substring(index, index+1).charAt(0);
            if(!numStack.isOperator(ch)){
                int val = ch - '0';
                numStack.push(val);
            }
            else{
                numStack.showStack();
                int val1 = numStack.pop();
                int val2 = numStack.pop();
                int res = numStack.cal(val1,val2,ch);
                numStack.push(res);
            }

            index++;
            if(index == expression.length()){
                break;
            }
        }

        int final_res = numStack.pop();
        System.out.printf("expression result: %d \n", final_res);
    }
}



class ArrayStack3{
    private int top = -1;
    private int maxSize;
    private int[] stack;

    public ArrayStack3(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean iSFull(){
        return top == this.maxSize-1;
    }

    public boolean isEmpty(){
        return  top == -1;
    }

    public void push(int val){
        if(iSFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = val;
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

        for (int i = top; i >= 0; i--){
            System.out.printf("Stack(top to bottom): %d \n", stack[i]);
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return stack[top];
    }

    public boolean isOperator(char opr){
        return opr == '+' || opr == '-' || opr == '*' || opr == '/';
    }

    public int cal(int val1, int val2, int opr){
        int res;
        switch (opr){
            case '+':
                res = val1 + val2;
                break;
            case '-':
                res = val2 - val1;
                break;
            case '*':
                res = val1 * val2;
                break;
            case '/':
                res = val2 / val1;
                break;
            default:
                res = 0;
                break;
        }

        return res;
    }
}
