package DataStructure.Stack;

import java.util.ArrayList;

public class DS_Infix_to_Suffix_Expression {
    public static void main(String[] args) {
        String infix = "1+((2+3)*4)-5";
        ArrayList<String> stringList = getStringList(infix);
        System.out.println(stringList);
//        String res = converter(stringList);
//        System.out.println(res);
    }

    public static ArrayList<String> getStringList(String infix){
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
                    System.out.println(ch);
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

    public static String converter(ArrayList<String> infixList){
        ArrayStack4 s1 = new ArrayStack4(20);
        ArrayStack4 s2 = new ArrayStack4(20);
        for(int i = 0; i < infixList.size(); i++){
            if(s1.isOperator(infixList.get(i))){
                //是运算符号
                if(!(infixList.get(i).equals("(") || infixList.get(i).equals(")"))){
                    //符号是运算符
                    if(s1.isEmpty()){
                        s1.push(infixList.get(i));
                    }
                    else if(s1.peek().equals("(")){
                        s1.push(infixList.get(i));
                    }
                    else if(s1.priority(infixList.get(i)) > s1.priority(s1.peek())){
                        s1.push(infixList.get(i));
                    }
                    else if(s1.priority(infixList.get(i)) <= s1.priority(s1.peek())){
                        String s1PeekOpr = s1.pop();
                        s2.push(s1PeekOpr);
                        i--;
                        continue;
                    }
                }else {
                    //符号是括号
                    if(infixList.get(i).equals("(")){
                        s1.push(infixList.get(i));
                    }
                    else if(infixList.get(i).equals(")")){
                        while (true){
                            String s1PopOpr = s1.pop();
                            if(s1PopOpr.equals("(")){
                                break;
                            }
                            s2.push(s1PopOpr);
                        }
                    }
                }

            }else {
                //是数字
                s2.push(infixList.get(i));
            }
        }

        s1.showStack();
        while (true){
            if(s1.isEmpty()){
                break;
            }
            s2.push(s1.pop());
        }

        //中缀表达式扫描完毕
        while (true){
            if(s2.isEmpty()){
                break;
            }
            s1.push(s2.pop());
        }

        StringBuilder tempRes = new StringBuilder();
        while (true){
            if(s1.isEmpty()){
                break;
            }

            tempRes.append(s1.pop());
            tempRes.append(" ");
        }

        String final_res = tempRes.toString();
        return final_res;
    }
}


