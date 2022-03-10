package highFre;

import list.ListNode;

//web https://leetcode-cn.com/problems/odd-even-linked-list/comments
public class Comments {

    private static class Solution {

        public Solution() {
        }
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode evenCur = head;
            ListNode oddHead = head.next;
            ListNode oddCur = oddHead;
            while (evenCur.next != null && oddCur.next != null) {
                evenCur.next = oddCur.next;
                evenCur = evenCur.next;
                oddCur.next = evenCur.next;
                oddCur = oddCur.next;
            }
            evenCur.next = oddHead;
            return head;
        }

	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] array = {1,2,3,4,5,6};
        ListNode l1 = new ListNode(array[0]);
        ListNode cur = l1;
        for (int i = 1; i < array.length; ++i) {
            ListNode listNode = new ListNode(array[i]);
            cur.next = listNode;
            cur = listNode;
        }


        ListNode fib = solution.oddEvenList(l1);
        while (fib != null) {
            System.out.println(fib.val);
            fib = fib.next;
        }
    }
}
