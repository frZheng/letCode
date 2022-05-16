package top100;

//web https://leetcode.cn/problems/intersection-of-two-linked-lists


import list.ListNode;

import java.util.ArrayList;
import java.util.HashSet;


public class intersectionOfTwoLinkedLists {
    private static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ArrayList<ListNode> AArray = new ArrayList<>();
            ArrayList<ListNode> BArray = new ArrayList<>();

            ListNode cur = headA;
            while (cur != null) {
                AArray.add(cur);
                cur = cur.next;
            }
            cur = headB;
            while (cur != null) {
                BArray.add(cur);
                cur = cur.next;
            }
            int ALen = AArray.size();
            int BLen = BArray.size();
            if (!(AArray.get(ALen-1) == BArray.get(BLen-1)))
                return null;
            int Ai = ALen - 2;
            int Bi = BLen - 2;

            while (Ai >= 0 && Bi>=0) {
                if (AArray.get(Ai) == BArray.get(Bi)){
                    Bi--;
                    Ai--;
                }
                else
                    return AArray.get(Ai+1);
            }
            return null;
        }

    }


    public static void main(String Args[]) {
        Solution solution = new Solution();

        ListNode headA = ListNode.arr2list(new int[] {4,1});
        ListNode headB = ListNode.arr2list(new int[] {5,6,1});
        ListNode headC = ListNode.arr2list(new int[] {8,4,5});
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headC;
        tail = headB;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headC;
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        while (intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }
}
