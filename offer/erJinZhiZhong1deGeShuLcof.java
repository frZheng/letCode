package offer;

//web https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof



public class erJinZhiZhong1deGeShuLcof {
    private static class Solution {

        public Solution() {
        }
        public int hammingWeight(int n) {
            int count=0;
            while(n!=0){
                count++;
                n=n&(n-1);
            }
            return count;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();


//        String str = "3,4,5,1,2,null,null";


        int b = solution.hammingWeight(4294967293);
        System.out.println(b);

    }



}
