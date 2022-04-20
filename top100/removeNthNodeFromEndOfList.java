package top100;

//web https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list


import list.ListNode;

import java.util.HashMap;

public class removeNthNodeFromEndOfList {
    private static class Solution {

        public Solution() {
        }


        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int size = 0;
            for (int i = 0; i < n; ++i) {
                if (node == null) return head;
                node = node.next;
                size++;
            }

            if (node != null) {
                node = node.next;
            }
            else {
                return head.next;
            }
            ListNode pre = head;
            if (node == null)
                if (pre.next == null)
                    return null;

            while (node != null) {
                node = node.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return head;
        }

    }

    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr = {1,2};
        ListNode head = ListNode.arr2list(arr);
        ListNode lists = solution.removeNthFromEnd(head, 2);
//        ListNode lists = head;
        while (lists != null) {
            System.out.println(lists.val);
            lists = lists.next;
        }

    }

}
