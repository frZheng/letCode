package offer;

//web https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof



import list.ListNode;

import java.util.*;


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

        int[] str = {1,2,3,8,11};
        root = array2ListNode(str);
        int[] str2 = {1,6,7};
        ListNode root2 = array2ListNode(str2);

        ListNode lists = solution.mergeTwoLists(root,root2);
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
