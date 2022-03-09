package highFre;

import list.ListNode;

// web: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
public class heBingLiangGePaiXuDeLianBiaoLcof {

    private static class Solution {

        public Solution() {
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dum = new ListNode(0);
            ListNode cur = dum; // cur用来指向新插入的节点
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;  // cur指向刚插入进来的节点
            }
            // 若l1 == null，直接把l2后面插入进来。否则就是l2=null了。
            // 跳出循环的条件是有一个为空了。
            cur.next = l1 != null ? l1 : l2;
            return dum.next;  // dum是空节点，新链表的头节点是dum的后一个节点
        }
	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2));
        l1.next.setNext(new ListNode(4));

        ListNode l2 = new ListNode(1);
        l2.setNext(new ListNode(3));
        l2.next.setNext(new ListNode(4));

        ListNode fib = solution.mergeTwoLists(l1, l2);
        while (fib != null) {
            System.out.println(fib.val);
            fib = fib.next;
        }
    }
}
