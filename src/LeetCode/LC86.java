package LeetCode;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode();
        ListNode tempHead = new ListNode();
        ListNode tempA = dummyHead;
        ListNode tempB = tempHead;
        dummyHead.next = head;

        while(true){

            if(tempA.next == null){
                break;
            }

            if(tempA.next.val < x){
                tempB.next = tempA.next;
                tempB = tempB.next;
                tempA.next = tempA.next.next;
                continue;
            }

            tempA = tempA.next;

        }

        tempB.next = dummyHead.next;
        return tempHead.next;

    }
}
