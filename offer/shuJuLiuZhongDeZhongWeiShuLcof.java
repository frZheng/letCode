package offer;

//web https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class shuJuLiuZhongDeZhongWeiShuLcof {
    private static class Solution {

        public Solution() {
        }
        PriorityQueue<Integer> left;//大顶
        PriorityQueue<Integer> right;//小顶
        /** initialize your data structure here. */
        public void MedianFinder() {
            left=new PriorityQueue<>((n1,n2)->n2-n1);
            right=new PriorityQueue<>();
        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if(left.size()+1<right.size())
                left.add(right.poll());
        }

        public double findMedian() {
            if(right.size()>left.size())return right.peek();
            return (double)(left.peek()+right.peek())/2;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();
        String[] arr = {"MedianFinder","addNum","addNum","findMedian","addNum","findMedian"};
        String input = "[],[1],[2],[],[3],[]";
//        for (int i = 0; i < arr.length; ++i) {
//            if (arr[i].equals("MedianFinder")) {
//
//            }
//        }
//        boolean lists = solution.isSubStructure(root,subRoot);
//        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
