package offer;


import list.ListNode;



//web https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof

public class congWeiDaoTouDaYinLianBiaoLcof {

    private static class Solution {

        public Solution() {
        }
        public int[] reversePrint(ListNode head) {
            int len = 0;

            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                ++len;
            }

            int[] res = new int[len];
            cur = head;
            for (int i = len - 1; i >= 0; --i) {
                res[i] = cur.val;
                cur = cur.next;
            }
            return res;
        }

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

        int[] res = solution.reversePrint(l1);

        for(int i : res){
            System.out.println(i);
        }

    }
}
