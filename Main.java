import java.util.*;


public class Main {

    static class Solu{
        Solu(){

        }
        public int res;
        void dfs(int i, int level,int[][] triangle,int val){
            if(level==triangle.length-1){
                res = Math.max(res,val+triangle[level][i]);
                if(i<triangle[level].length-1)
                    res = Math.max(res,val+triangle[level][i+1]);
            } else {
//                System.out.println(i+" "+level);
                dfs(i,level+1,triangle,triangle[level][i]+val);
                dfs(i+1,level+1,triangle,triangle[level][i]+val);
            }
        }

        public int maximumTotal (int[][] triangle) {
            // write code here
            res = Integer.MIN_VALUE;
//            res=triangle[0][0];
            dfs(0,0,triangle,0);
            return res;

        }

        public int networkDelayTime (int[][] times, int n, int k) {
            new HashMap<>()
        }
    }

    public static void main(String[] args) {
//        int[][] triangle = {{2}, {3,4}, {6,5,7}, {4,1,3,8}};
//        Solu solu = new Solu();
//        int res = solu.maximumTotal(triangle);
//        System.out.println(res);
    }
}
