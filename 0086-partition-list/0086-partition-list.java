class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), large = new ListNode(0);
        ListNode s = small, l = large;

        while (head != null) {
            if (head.val < x) s = s.next = head;
            else l = l.next = head;
            head = head.next;
        }

        l.next = null;
        s.next = large.next;

        return small.next;
    }
}