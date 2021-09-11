package LeetCode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;

        while(true){
            if(cur == null || cur.next == null){
                break;
            }
            if(cur.val == next.val){
                while(true){
                    if(next == null || cur.val != next.val){
                        break;
                    }
                    next = next.next;
                }
                prev.next = next;
                cur = next;
                if(cur != null){
                    next = cur.next;
                }
                continue;
            }

            prev = prev.next;
            cur = cur.next;
            if(next.next != null){
                next = next.next;
            }
        }

        return dummyHead.next;

    }
}
