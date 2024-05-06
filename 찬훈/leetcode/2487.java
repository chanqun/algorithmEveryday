import java.util.*;

class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        head.next = removeNodes(head.next);

        if (head.next != null && head.val < head.next.val) {
            return head.next;
        }

        return head;
    }
}

