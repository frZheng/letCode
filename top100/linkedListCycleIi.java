package top100;


//web https://leetcode.cn/problems/linked-list-cycle-ii


import list.ListNode;


public class  linkedListCycleIi {
    private static class Solution {

        public Solution() {
        }
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;

        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {3,2,0,-4};
        ListNode node = ListNode.arr2list(arr);
        ListNode cur = node;
        while (cur.next!=null) {
            cur = cur.next;
        }
        cur.next = node.next.next;
        ListNode lists = solution.detectCycle(node);
//        while (lists!=null) {
//            System.out.println(lists.val);
//            lists = lists.next;
//        }

    }

}
