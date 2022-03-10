package offer;


import list.ListNode;



//web https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof

public class fanZhuanLianBiaoLcof {

    private static class Solution {

        public Solution() {
        }
        public ListNode reverseList(ListNode head) {
            if (head == null) return head;
            ListNode cur = head.next;
            ListNode newHead = head;
            newHead.next = null;
            ListNode node;
//            node.next = null;

//            int i=0;
            while(cur != null){
                node = cur;
                cur = cur.next;
                node.next = newHead;
                newHead = node;

//                System.out.println(i++);
            }
            return newHead;
        }

	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] array = {1,2,3,4,5};
        ListNode l1 = new ListNode(array[0]);
        ListNode cur = l1;
        for (int i = 1; i < array.length; ++i) {
            ListNode listNode = new ListNode(array[i]);
            cur.next = listNode;
            cur = listNode;
        }

        ListNode fib = solution.reverseList(l1);

        while (fib != null) {
            System.out.println(fib.val);
            fib = fib.next;
        }

    }
}
