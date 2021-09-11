package DataStructure.Stack;

public class DS_Linked_List_Stack {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(3);
        linkedListStack.push(4);
        linkedListStack.pop();
        linkedListStack.showStack();
    }
}

class LinkedListStack{
    private ListNode head = new ListNode(0);

    public void push(int val){
        ListNode add = new ListNode(val);
        add.next = head.next;
        head.next = add;
    }

    public int pop(){
        if(head.next == null){
            throw new RuntimeException("stack is empty");
        }

        int val = head.next.val;
        head.next = head.next.next;
        return val;
    }

    public void showStack(){
        if (head.next == null){
            System.out.println("stack is empty");
            return;
        }

        ListNode temp = head.next;

        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
