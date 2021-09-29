package DataStructure.Stack;

import java.util.ArrayList;

public class DS_Reverse_Polish_Notation_Calculator_2 {

    public static void main(String[] args) {
//        String expression = "30 4 + 5 * 6 -";
////        ArrayList<String> arrayList = getList(expression);
////        int result = calculator(arrayList);
////        System.out.printf("expression result: %d \n", result);
        String infix = "1+((2+3)*4)-5";
        //中缀表达式字符串=>中缀表达式链表
        ArrayList<String> inStringList = getInfixList(infix);
        System.out.println("infix: "+inStringList);
        ArrayList<String> postFixList = getPostfixList(inStringList);
        System.out.println("postfix: "+postFixList);
        System.out.println(calculator(postFixList));


    }

    public static ArrayList<String> getList(String expression){
        String[] list = expression.split(" ");
        ArrayList<String> ret = new ArrayList<String>();
        for (String item : list){
            ret.add(item);
        }
        return ret;
    }

    public static ArrayList<String> getInfixList(String infix){
        ArrayList<String> infixList = new ArrayList<String>();
        int index = 0;
        char ch;
        String num ="";
        while (true){
            ch = infix.charAt(index);
            if(ch < '0' || ch > '9'){
                //中缀表达式为运算符
                infixList.add(""+ch);
                index++;
            }
            else{
                //中缀表达式位数字
                while (true){
                    if(index >= infix.length() || ((ch = infix.charAt(index)) < '0' || ch > '9')){
                        infixList.add(num);
                        num = "";
                        break;
                    }
                    num += ch;
                    index++;
                }

            }

            if(index >= infix.length()){
                break;
            }


        }

        return infixList;
    }

    public static ArrayList<String> getPostfixList(ArrayList<String> infixList){
        ArrayStack4 s1 = new ArrayStack4(30);
        ArrayList<String> postFixList = new ArrayList<String>();

        for(String item : infixList){
            if (s1.isOperator(item)){
                //是符号
                if(!(item.equals("(") || item.equals(")"))){
                    //不是括号的运算符
                    if(s1.isEmpty()){
                        s1.push(item);
                    }
                    else if(s1.priority(item) <= s1.priority(s1.peek())){
                        while (true){
                            if(s1.isEmpty() || (s1.priority(item) > s1.priority(s1.peek()))){
                                break;
                            }
                            postFixList.add(s1.pop());
                        }
                        s1.push(item);
                    }
                    else if(s1.priority(item) > s1.priority(s1.peek())){
                        s1.push(item);
                    }
                }
                else {
                    //为括号的情况
                    if(item.equals("(")){
//                        s1.showStack();
//                        System.out.println("---------------");
                        s1.push(item);
                    }
                    else if(item.equals(")")){
                        while (true){
                            if(s1.peek().equals("(")){
                                s1.pop();
                                break;
                            }
                            postFixList.add(s1.pop());
                        }
                    }
                }

            }
            else {
                //是数字
                postFixList.add(item);
            }
        }

        //完成对中缀表达式链表遍历
        while (true){
           if(s1.isEmpty()){
               break;
           }
           postFixList.add(s1.pop());
        }

        return postFixList;

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