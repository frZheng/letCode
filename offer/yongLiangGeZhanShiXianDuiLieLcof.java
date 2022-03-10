package highFre;


import java.util.LinkedList;

//web https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
// 用两个栈实现一个队列
public class yongLiangGeZhanShiXianDuiLieLcof {

    private static class CQueue {
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            } else return stack2.pop();
        }

	}
	public static void main(String Args[]) {
        CQueue cqueue = new CQueue();
        int res = cqueue.deleteHead();
        System.out.println(res);
        cqueue.appendTail(5);
        cqueue.appendTail(2);
        res = cqueue.deleteHead();
        System.out.println(res);
        res = cqueue.deleteHead();
        System.out.println(res);

    }
}
