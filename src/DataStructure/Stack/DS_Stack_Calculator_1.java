package DataStructure.Stack;

public class DS_Stack_Calculator_1 {
    public static void main(String[] args) {
        Calculator1 calculator1 = new Calculator1();
        calculator1.calculate("3+2*6-2=");
    }
}

class Calculator1{
    private ArrayDoubleStack numStack = new ArrayDoubleStack(20);
    private ArrayCharStack oprStack = new ArrayCharStack(20);

    public void calculate(String exp){

        //符号和数字入栈完成
        for(int i=0; i < exp.length()-1; i++){
            if(Character.isDigit(exp.charAt(i))){
                double num = (double)(exp.charAt(i)-'0');
                numStack.push(num);
            }else{
                if(oprStack.isEmpty()){
                    oprStack.push(exp.charAt(i));
                }else if((exp.charAt(i) == '*' ||  exp.charAt(i) == '/') && (oprStack.peek() == '+' || oprStack.peek() == '-' )){
                    oprStack.push(exp.charAt(i));
                }else{
                    double val2 = numStack.pop();
                    double val1 = numStack.pop();
                    char opr = oprStack.pop();
                    double res = result(val1, val2, opr);
                    numStack.push(res);
                    oprStack.push(exp.charAt(i));
                }
            }

        }

        //最终计算
        while (!oprStack.isEmpty()){
            double num2 = numStack.pop();
            double num1 = numStack.pop();
            char oprf = oprStack.pop();
            double tempRes = result(num1, num2, oprf);
            numStack.push(tempRes);
        }

        double finalRes = numStack.pop();
        System.out.println(finalRes);

    }

    public double result(double val1, double val2, char opr){
        double result;
        switch (opr){
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val1 / val2;
                break;
            default:
                result = 0;
        }

        return result;

    }
}

class ArrayCharStack{
    private int top = -1;
    private int maxSize;
    private char[] stack = null;

    public ArrayCharStack(int maxSize){
        this.maxSize = maxSize;
        stack = new char[this.maxSize];

    }

    public boolean isEmpty(){
        return  top == -1;
    }

    public boolean isFull(){
        return  top == this.maxSize-1;
    }

    public void push(char val){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = val;
    }

    public char pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        char ret = stack[top];
        top--;
        return ret;
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.printf("Stack(top to bottom) %c \n", stack[i]);
        }
    }

    public char peek(){
        return stack[top];
    }


}

class ArrayDoubleStack{
    private int top = -1;
    private int maxSize;
    private double[] stack = null;

    public ArrayDoubleStack(int maxSize){
        this.maxSize = maxSize;
        stack = new double[this.maxSize];

    }

    public boolean isEmpty(){
        return  top == -1;
    }

    public boolean isFull(){
        return  top == this.maxSize-1;
    }

    public void push(double val){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = val;
    }

    public double pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        double ret = stack[top];
        top--;
        return ret;
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.printf("Stack(top to bottom) %f \n", stack[i]);
        }
    }

    public double peek(){
        return stack[top];
    }


}



