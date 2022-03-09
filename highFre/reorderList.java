package highFre;

import list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

//web https://leetcode-cn.com/problems/reorder-list
public class reorderList {

    private static class Solution {

        public Solution() {
        }
        public void reorderList(ListNode head) {
            ListNode fast = head, slow = head;
            //求出中点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //right就是右半部分 12345 就是45  1234 就是34
            ListNode right = slow.next;
            //断开左部分和右部分
            slow.next = null;
            //反转右部分 right就是反转后右部分的起点
            right = reverseList(right);
            //左部分的起点
            ListNode left = head;
            //进行左右部分来回连接
            //这里左部分的节点个数一定大于等于右部分的节点个数 因此只判断right即可
            while (right != null) {
                ListNode curLeft = left.next;
                left.next = right;
                left = curLeft;

                ListNode curRight = right.next;
                right.next = left;
                right = curRight;
            }
        }
        public ListNode reverseList(ListNode head) {
            ListNode headNode = new ListNode(0);
            ListNode cur = head;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = headNode.next;
                headNode.next = cur;
                cur = next;
            }
            return headNode.next;
        }

//        public void reorderList(ListNode head) {
//            // 双指针的做法
//            ListNode cur = head;
//            // ArrayList底层是数组，可以使用下标随机访问
//            ArrayList<ListNode> list = new ArrayList<>();
//            while (cur != null){
//                list.add(cur);
//                cur = cur.next;
//            }
//            cur = head;  // 重新回到头部
//            int l = 1, r = list.size() - 1;  // 注意左边是从1开始
//            int count = 0;
//            while (l <= r){
//                if (count % 2 == 0){
//                    // 偶数
//                    cur.next = list.get(r);
//                    r--;
//                }else {
//                    // 奇数
//                    cur.next = list.get(l);
//                    l++;
//                }
//                // 每一次指针都需要移动
//                cur = cur.next;
//                count++;
//            }
//            // 当是偶数的话，需要做额外处理
//            if (list.size() % 2== 0){
//                cur.next = list.get(l);
//                cur = cur.next;
//            }
//
//            // 注意结尾要结束一波
//            cur.next = null;
//        }

//        public void reorderList(ListNode head) {
//            // 使用双端队列的方法来解决
//            LinkedList<ListNode> de = new LinkedList<ListNode>();
//            // 这里是取head的下一个节点，head不需要再入队了，避免造成重复
//            ListNode cur = head.next;
//            while (cur != null){
//                de.offer(cur);
//                cur = cur.next;
//            }
//            cur = head;  // 回到头部
//
//            int count = 0;
//            while (!de.isEmpty()){
//                if (count % 2 == 0){
//                    // 偶数，取出队列右边尾部的值
//                    cur.next = de.pollLast();
//                }else {
//                    // 奇数，取出队列左边头部的值
//                    cur.next = de.poll();
//                }
//                cur  = cur.next;
//                count++;
//            }
//            cur.next = null;
//        }

	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] array = {1,2,3,4,5};
        ListNode l1 = new ListNode(array[0]);
        ListNode cur = l1;
        for (int i = 1; i < array.length; ++i) {
            ListNode listNode = new ListNode(array[i]);
            cur.next = listNode;
            cur = listNode;
        }

        solution.reorderList(l1);
        ListNode fib = l1;
        while (fib != null) {
            System.out.println(fib.val);
            fib = fib.next;
        }
    }
}
