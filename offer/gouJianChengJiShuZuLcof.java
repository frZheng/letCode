package offer;

 //web https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof



public class gouJianChengJiShuZuLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] constructArr(int[] a) {
            int n = a.length;
            int[] B = new int[n];
            for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
                B[i] = product;
            for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
                B[i] *= product;
            return B;
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
