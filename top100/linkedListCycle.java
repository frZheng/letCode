package top100;


//web https://leetcode.cn/problems/linked-list-cycle


import list.ListNode;


public class  linkedListCycle {
    private static class Solution {

        public Solution() {
        }
        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;
            ListNode fast=head.next;
            ListNode low=head;
            while (fast!=null) {
                if (fast==low)
                    return true;
                low = low.next;
                if(fast.next==null)
                    return false;
                fast = fast.next.next;
            }
            return false;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {3,2,0,-4};
        ListNode node = ListNode.arr2list(arr);
        ListNode cur = node;
        while (cur.next!=null) {
            cur = cur.next;
        }
        cur.next = node.next.next;
        boolean lists = solution.hasCycle(node);
        System.out.println(lists);

    }

}
