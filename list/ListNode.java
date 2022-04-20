package list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode arr2list(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; ++i) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}
