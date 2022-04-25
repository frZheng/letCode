package top100;

//web https://leetcode-cn.com/problems/merge-two-sorted-lists


import com.sun.org.apache.bcel.internal.generic.RETURN;
import list.ListNode;



public class    mergeTwoSortedLists {
    private static class Solution {

        public Solution() {
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 类似归并排序中的合并过程
//            ListNode dummyHead = new ListNode(0);
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummyHead;
            if (l1.val > l2.val) {
                dummyHead = l2;
                l2 = l2.next;
             } else {
                dummyHead = l1;
                l1 = l1.next;
            }
            ListNode cur = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }

                cur = cur.next;
            }
            // 任一为空，直接连接另一条链表
            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return dummyHead;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr1 = {1,2,4};
        ListNode list1 = ListNode.arr2list(arr1);
        int[] arr2 = {1,3,4};
        ListNode list2 = ListNode.arr2list(arr2);

        ListNode lists = solution.mergeTwoLists(list1, list2);
        String msg = "";
        while (lists != null) {
            msg += lists.val + ",";
            lists = lists.next;
        }
//        System.out.println(msg);
//        long l = System.currentTimeMillis(); // 毫秒
//        System.out.println(String.valueOf(l));

//        String s = "?";

    }

}
