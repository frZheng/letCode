package offer;

 //web https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof



public class gouJianChengJiShuZuLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] constructArr(int[] a) {
            int sum = 1;
            for (int i = 0; i < a.length; ++i)
                sum *= a[i];
            int[] result = new int[a.length];
//            for (int i = 0; i < a.length; ++i)
//                result[i] = sum/(i+1);
            return result;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();


//        String str = "3,4,5,1,2,null,null";

        int[] nums = {1,2,3,4,5};
        int[] bs = solution.constructArr(nums);
        for (int b : bs)
            System.out.println(b);

    }



}
