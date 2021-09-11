package DataStructure.Stack;

import java.util.ArrayList;

public class DS_Reverse_Polish_Notation_Calculator_2 {

    public static void main(String[] args) {
        String expression = "30 4 + 5 * 6 -";
        ArrayList<String> arrayList = getList(expression);
        int result = calculator(arrayList);
        System.out.printf("expression result: %d \n", result);



    }

    public static ArrayList<String> getList(String expression){
        String[] list = expression.split(" ");
        ArrayList<String> ret = new ArrayList<String>();
        for (String item : list){
            ret.add(item);
        }
        return ret;
    }

    public static int calculator(ArrayList<String> arrayList){
        ArrayStack4 calStack = new ArrayStack4(30);
        int res;
        for(String item: arrayList){
            if(calStack.isOperator(item)){
                //是运算符号
                int val1 = Integer.parseInt(calStack.pop());
                int val2 = Integer.parseInt(calStack.pop());
                if(item.equals("+")){
                    res = val2 + val1;
                }
                else if(item.equals("-")){
                    res = val2 - val1;
                }
                else if(item.equals("*")){
                    res = val2 * val1;
                }
                else if(item.equals("/")){
                    res = val2 / val1;
                }else {
                    //没有匹配的符号
                    res = 0;
                }
                String tempRes = res+"";
                calStack.push(tempRes);
            }
            else {
                //是数字
                calStack.push(item);
            }
        }

        int ret =  Integer.parseInt(calStack.pop());
        return ret;
    }

}

class ArrayStack4{
    private int top = -1;
    private int maxSize;
    private String[] stack;

    public ArrayStack4(int maxSize){
        this.maxSize = maxSize;
        this.stack = new String[maxSize];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.maxSize-1;
    }

    public void push(String val){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }

        this.top++;
        stack[top] = val;
    }

    public String pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }

        String ret = stack[top];
        top--;
        return ret;
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }

        for (int i = top; i >= 0; i--){
            System.out.printf("Stack(top to bottom): %s \n", stack[i]);
        }
    }

    public String peek(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return stack[top];
    }

    public boolean isOperator(String opr){
        return opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/") || opr.equals("(") || opr.equals(")");
    }

    public int priority(String opr){
        if(opr.equals("*") || opr.equals("/")){
            return 1;
        }
        else if(opr.equals("+") || opr.equals("-")){
            return 0;
        }
        else {
            return -1;
        }
    }

}