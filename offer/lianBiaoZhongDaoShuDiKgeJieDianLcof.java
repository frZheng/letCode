package offer;

//web https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof



import list.ListNode;

import java.util.*;


public class lianBiaoZhongDaoShuDiKgeJieDianLcof {
    private static class Solution {

        public Solution() {
        }
        public ListNode getKthFromEnd(ListNode head, int k) {

            // 快慢指针，先让快指针走k步，然后两个指针同步走，
            // 当快指针走到头时，慢指针就是链表倒数第k个节点。
            ListNode fastNode = head, slowNode = head;
            while (fastNode != null && k > 0) {

                fastNode = fastNode.next;
                k--;
            }

            while (fastNode != null) {

                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }

            return slowNode;
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

        int[] str = {1,2,3,4,5};
        root = array2ListNode(str);

        ListNode lists = solution.getKthFromEnd(root, 1);
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
