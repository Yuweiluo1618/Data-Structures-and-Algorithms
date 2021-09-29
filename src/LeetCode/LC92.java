package LeetCode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode tempFront = dummyHead;
        ListNode tempRear = dummyHead;
        ListNode revHead = new ListNode();


        for(int i = 0; i < left -1; i++){
            tempFront = tempFront.next;
        }

        for(int i = 0; i < right; i++){
            tempRear = tempRear.next;
        }

        revHead = tempFront.next;
        tempFront.next = tempRear.next;
        tempRear.next = null;

        ListNode revNewHead = reverse(revHead);

        revHead.next =  tempFront.next;
        tempFront.next = revNewHead;

        return dummyHead.next;



    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode revNewHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return revNewHead;

    }
}
