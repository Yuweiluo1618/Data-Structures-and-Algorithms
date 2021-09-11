package DataStructure.Linked_List;

import java.util.Stack;

public class DS_Single_Linked_List {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(new HeroNode(1, "songjiang", "jishiyu"));
        list.addByOrder(new HeroNode(2, "lujunyi", "huoqiling"));
        list.addByOrder(new HeroNode(4, "linchong", "baozitou"));
        list.addByOrder(new HeroNode(3, "wuyong", "zhiduoxing"));
//        list.delete(5);
//        list.addByOrder(new DataStructure.Linked_List.HeroNode(3, "wuyong", "zhiduoxing"));
//        System.out.println(totalNode(list.getHead()));
//        System.out.println(findIndexFromBackA(list.getHead(), 4));
//        System.out.println(findIndexFromBackA(list.getHead(), 5));
//        System.out.println(findIndexFromBackB(list.getHead(), 4));
//        System.out.println("-----------------------------------------");
//        list.showList();
//      list.updateList(new DataStructure.Linked_List.HeroNode(5, "xiaolin", "baozi"));

//        reverseLinkedList(list.getHead());
//        list.showList();
        reversePrintList(list.getHead());

    }

    public static int totalNode(HeroNode head){
        int count = 0;

        if(head.next == null){
            return count;
        }

        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            temp = temp.next;
            count++;
        }

        return count;

    }

    //查找倒数第index个节点方法1 双遍历
    public static HeroNode findIndexFromBackA(HeroNode head, int index){

        if(head.next == null){
            return null;
        }

        int nodeNum = totalNode(head);
        HeroNode temp = head.next;

        if(index > nodeNum || index <= 0){
            return null;
        }

        for(int i = 0; i < (nodeNum - index); i++){
            temp = temp.next;
        }

        return  temp;


    }

    //查找倒数第index节点方法2 双指针
    public static HeroNode findIndexFromBackB(HeroNode head, int index){
        if(head.next == null){
            return null;
        }

        HeroNode fastTemp = head.next;
        for (int i = 0; i < index; i++){
            fastTemp = fastTemp.next;
        }

        HeroNode slowTemp = head.next;
        while (true){
            if(fastTemp == null){
                break;
            }

            fastTemp = fastTemp.next;
            slowTemp = slowTemp.next;
        }

        return slowTemp;
    }

    //反转链表
    public static void reverseLinkedList(HeroNode head){

        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next;
        HeroNode reverseHead = new HeroNode(0,"","");

        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;

    }

    //链表逆序打印
    public static void reversePrintList(HeroNode head){
        if(head.next == null){
            System.out.println("linked list is empty");
        }

        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
}



class SingleLinkedList{
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode addNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = addNode;
    }

//    two pointer
        public void addByOrder2(HeroNode addNode){
        if(head.next == null){
            head.next = addNode;
            return;
        }

        HeroNode temp1 = head.next;
        HeroNode temp2 = head;
        while (true){
            if(temp1 == null || temp1.no >= addNode.no ){
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null){
            temp2.next = addNode;
            return;
        }

        if(temp1.no == addNode.no){
            System.out.println("hero is exist");
            return;
        }

        temp2.next = addNode;
        addNode.next = temp1;

    }

    public void addByOrder(HeroNode addNode){
        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > addNode.no ){
                break;
            }
            if(temp.next.no == addNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            System.out.println("node already exist");
        }else {
            addNode.next = temp.next;
            temp.next = addNode;
        }


    }

    public void updateList(HeroNode updateNode){
       if(head.next == null){
           System.out.println("linked list is empty");
           return;
       }

       HeroNode temp = head.next;
       boolean flag = false;

       while (true){
           if(temp == null){
               break;
           }
           if(temp.no == updateNode.no){
               flag = true;
               break;
           }
           temp = temp.next;
       }

       if(flag){
           temp.name = updateNode.name;
           temp.nickname = updateNode.nickname;
       }else {
           System.out.println("Node is not exist");
       }
    }

    public void delete(int no){

        if(head.next == null){
            System.out.println("linked list is empty");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("Node not exist");
        }
    }

    public void showList(){
        HeroNode temp = head;
        if(head.next == null){
            System.out.println("linked list is empty");
            return;
        }

        temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DataStructure.Linked_List.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}