package DataStructure.Stack;

public class DS_Stack_Calculator_2 {
    public static void main(String[] args) {
        ArrayCalStack numStack = new ArrayCalStack(20);
        ArrayCalStack oprStack = new ArrayCalStack(20);
        String expression = "2*(3-1)";
        int index = 0;
        boolean isMultiDigits = false;

        while (true){
            char ch = expression.substring(index, index+1).charAt(0);

            if(oprStack.isOperator(ch)){
                isMultiDigits = false;
                if(oprStack.isEmpty()){
                    //符号栈是空栈
                    oprStack.push(ch);
                }
                else{
                    //符号栈不是空栈
                    if(ch == '('){
                        //入栈符号为(
                        oprStack.push(ch);
                    }
                    else if(oprStack.priority(ch) == 2){
                        //入栈符号为‘）’
                        while (true){
                            int opr = oprStack.pop();
                            if(opr == '('){
                                break;
                            }
                            int val1 = numStack.pop();
                            int val2 = numStack.pop();
                            int res = oprStack.calculation(val1, val2, opr);
                            numStack.push(res);

                        }
                    }
                    else if(oprStack.priority(ch) <= oprStack.priority(oprStack.peek())){
                        //入栈优先级小于等于栈顶优先级
                        int val1 = numStack.pop();
                        int val2 = numStack.pop();
                        int opr = oprStack.pop();
                        int result = oprStack.calculation(val1,val2,opr);
                        numStack.push(result);
                        oprStack.push(ch);
                    }
                    else if(oprStack.priority(ch) > oprStack.priority(oprStack.peek())){
                        //入栈优先级大于栈顶优先级
                        oprStack.push(ch);
                    }
                }
            }else{
                //是数字
                int num = ch -'0';
                if (isMultiDigits) {
                    num = num + numStack.pop() * 10;
                }
                numStack.push(num);
                isMultiDigits = true;
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        numStack.showStack();

        while (true){
            if(oprStack.isEmpty()){
                break;
            }
            int val1 = numStack.pop();
            int val2 = numStack.pop();
            int opr = oprStack.pop();
            int result = oprStack.calculation(val1,val2,opr);
            numStack.push(result);

        }

        int finalResult = numStack.pop();
        System.out.printf("Expression Result is: %d \n",finalResult);
    }
}


class ArrayCalStack{
    private int top = -1;
    private int maxSize;
    private int[] stack = null;

    public ArrayCalStack(int maxSize){
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
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return stack[top];
    }

    public boolean isOperator(int operator){
        return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '(' || operator == ')';
    }

    public int priority(int operator){
        if(operator == ')'){
            return 2;
        }else if(operator == '*' || operator == '/'){
            return 1;
        }
        else if(operator == '+' || operator == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public int calculation(int val1, int val2, int operator){
        int result;
        switch (operator){
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val2 - val1;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val2 / val1;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }


}
