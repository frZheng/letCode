package top100;

//web https://leetcode-cn.com/problems/add-two-numbers


import list.ListNode;

public class addTwoNumbers {
    private static class Solution {

        public Solution() {
        }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode head = null;
//            l1 = l1.next;l2 = l2.next;
//            int carryBit = 0;
            int carryBit = 0;
//            ListNode tail;
            int value = l1.val + l2.val;
            if (value > 9) {
                carryBit = 1;
                value -= 10;
            }
            ListNode head = new ListNode(value);
            l1 = l1.next;l2 = l2.next;
            ListNode tail = head;
            while (l1 != null && l2 != null) {
                value = l1.val + l2.val + carryBit;
                if (value > 9) {
                    carryBit = 1;
                    value -= 10;
                } else {
                    carryBit = 0;
                }
                tail.next = new ListNode(value);
                tail = tail.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode l3 = null;
            if (l1 != null)l3 = l1;
            if (l2 != null)l3 = l2;
            while (l3 != null) {
                value = l3.val + carryBit;
                if (value > 9) {
                    carryBit = 1;
                    value -= 10;
                } else {
                    carryBit = 0;
                }
                tail.next = new ListNode(value);
                tail = tail.next;
                l3 = l3.next;
            }
            if (carryBit==1) {
                tail.next = new ListNode(1);
            }
            return head;
        }

    }
    static public ListNode ints2ListNode(int[] list) {
        ListNode tail = null;
        ListNode head = null;
        head = new ListNode(list[0]);
        tail = head;
        for (int i = 1; i < list.length; ++i) {
            tail.next = new ListNode(list[i]);
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {9,9,9,9,9,9,9};
        ListNode l1 = ints2ListNode(nums);
        int[] nums2 = {9,9,9,9};
        ListNode l2 = ints2ListNode(nums2);
        ListNode lists = solution.addTwoNumbers(l1, l2);
//        ListNode lists = l1;
        while (lists != null) {
            System.out.println(lists.val);
            lists = lists.next;
        }

    }

}
