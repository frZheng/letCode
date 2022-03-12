package offer;

//web https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof



import list.ListNode;

import java.util.*;


public class liangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    private static class Solution {

        public Solution() {
        }


        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode Ahead = headA;
            ListNode Bhead = headB;
            // 两个地址分别走一边A,B, 这样公共地址就可以在走第二遍的时候对其
            while(Ahead != Bhead){
                Ahead = Ahead == null ? headB : Ahead.next;
                Bhead = Bhead == null ? headA : Bhead.next;
            }
            return Ahead;
        }
    }
    public static ListNode array2ListNode(int[] arr) {

        ListNode root = new ListNode(arr[0]);
        ListNode cur = root;
        for (int i = 1; i < arr.length; ++i) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return root;
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        ListNode root = null;

        int[] str = {4,1,};
        root = array2ListNode(str);
        int[] str2 = {5,0,1,};
        ListNode root2 = array2ListNode(str2);
        int[] str3 = {8,4,5};
        ListNode root3 = array2ListNode(str3);
        ListNode root4 = root;
        while (root4.next != null) {
            root4 = root4.next;
        }
        root4.next = root3;

        root4 = root2;
        while (root4.next != null) {
            root4 = root4.next;
        }
        root4.next = root3;

        ListNode lists = solution.getIntersectionNode(root, root2);
//        ListNode lists = root;
        while (lists != null){
            System.out.println(lists.val);
            lists = lists.next;
        }


//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
