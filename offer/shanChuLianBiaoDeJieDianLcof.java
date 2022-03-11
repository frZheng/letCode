package offer;

//web https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof



import list.ListNode;

import java.util.*;


public class shanChuLianBiaoDeJieDianLcof {
    private static class Solution {

        public Solution() {
        }
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null)return head;
            if (val == head.val) return head.next;
            ListNode node = head.next;
            ListNode pre = head;
            while (node != null) {
                if (val == node.val) {
//                    if (node.next != null) {
//                        node.next = node.next.next;
//                        break;
//                    }
                    pre.next = node.next;
                    break;
                }
                pre = node;
                node = node.next;
            }
            return head;
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

        int[] str = {4,5,1,9};
        root = array2ListNode(str);

        ListNode lists = solution.deleteNode(root, 5);
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
