package LeetCode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null){
            return head;
        }
        int listSize = 0;
        ListNode temp = head;

        while(true){

            if(temp == null){
                break;
            }
            listSize++;
            temp = temp.next;

        }

        //找到要剪断的节点
        int indexNode = k % listSize;

        ListNode newDummyHead = new ListNode();
        temp = head;

        for(int i = 0; i < listSize-indexNode-1; i++){
            temp = temp.next;
        }

        newDummyHead.next = temp.next;
        temp.next = null;

        temp = newDummyHead;

        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = head;

        return newDummyHead.next;

    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
