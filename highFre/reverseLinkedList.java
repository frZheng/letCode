package highFre;

import list.ListNode;

//web https://leetcode-cn.com/problems/reverse-linked-list
public class  reverseLinkedList {

    private static class Solution {

        public Solution() {
        }
//        public ListNode reverseList(ListNode head) {
//            ListNode prev = null;
//            ListNode cur = head;
//            ListNode temp = null;
//            while (cur != null) {
//                temp = cur.next;// 保存下一个节点
//
//                // 头插法
//                cur.next = prev;// 将一个节点从头部插入到节点
//                prev = cur;
//
//                cur = temp;// 第一句和这句就是遍历列表的
//            }
//            return prev;
//        }
        public ListNode reverseList(ListNode head) {

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
