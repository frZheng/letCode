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
}
