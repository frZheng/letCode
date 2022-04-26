package top100;

//web https://leetcode-cn.com/problems/merge-k-sorted-lists


import list.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class     mergeKSortedLists {
    private static class Solution {

        public Solution() {
        }

//        public boolean judgeNull(ListNode[] lists) {
//            for (int i = 0; i < lists.length; ++i){
//                if (lists[i] != null)
//                    return true;
//            }
//            return false;
//        }
//        public ListNode mergeKLists(ListNode[] lists) {
//            int[] ints = new int[lists.length];
//            ListNode head = null;
//            ListNode cur = head;
//            while (judgeNull(lists)){
//                int minIndex = -1;
//                int minVal = Integer.MAX_VALUE;
//                for (int i = 0; i < lists.length; ++i) {
//                    if(lists[i] != null && minVal > lists[i].val) {
//                        minIndex = i;
//                        minVal = lists[i].val;
//                    }
//                }
//                if (head!=null) {
//                    cur.next = lists[minIndex];
//                    cur = cur.next;
//                } else {
//                    head = lists[minIndex];
//                    cur = head;
//                }
//                lists[minIndex] = lists[minIndex].next;
//            }
//            return head;
//        }

        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length == 0) {
                return null;
            }

            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (ListNode list : lists) {
                if (list == null) {
                    continue;
                }
                pq.add(list);
            }

            while (!pq.isEmpty()) {
                ListNode nextNode = pq.poll();
                curr.next = nextNode;
                curr = curr.next;
                if (nextNode.next != null) {
                    pq.add(nextNode.next);
                }
            }
            return dummyHead.next;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[][] arr = {{1, 4, 5},{1,3,4},{2,6}};
        ListNode[] listNodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            listNodes[i] = ListNode.arr2list(arr[i]);
        }

        ListNode lists = solution.mergeKLists(listNodes);
        while (lists != null){
            System.out.println(lists.val);
            lists = lists.next;
        }
    }

}
