package top100;

//web https://leetcode.cn/problems/palindrome-linked-list


import list.ListNode;

import java.util.ArrayList;



public class   palindromeLinkedList {
    private static class Solution {

        public Solution() {
        }



        public boolean isPalindrome(ListNode head) {
//            boolean result = false;
            if (head == null) return true;
            ListNode cur = head;
            ArrayList<ListNode> stack = new ArrayList<>();
            while (cur != null) {
                stack.add(cur);
                cur = cur.next;
            }
            int size = stack.size();
            for (int i = 0; i < size/2; ++i) {
                if (stack.get(i).val != stack.get(size-1-i).val)
                    return false;
            }
            return true;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
//        ListNode head = ListNode.arr2list(new int[]{1, 2, 2, 1});
        ListNode head = ListNode.arr2list(new int[]{1, 2});
        boolean s = solution.isPalindrome(head);
        System.out.println(s);

    }
}
