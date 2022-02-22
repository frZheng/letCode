//import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

import Tree.TreeNode;


// 没能写出来
public class haoZiJiDeShuMuByLeetcodeSolutionKy65 {


    private static class Solution {



        public Solution() {
        }

        static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        static final int NUN_MAX = 30;
        static final int MOD = 1000000007;
        public int numberOfGoodSubsets(int[] nums) {
            int[] freq = new int[NUN_MAX + 1];
            for(int num:nums){
                ++freq[num];
            }
            int[] f = new int[1 << PRIMES.length];
            f[0] = 1;
            for(int i = 0; i < freq[1]; ++i){
                f[0] = f[0] * 2 % MOD;
            }
            for (int i = 0; i <= NUN_MAX; ++i) {
                if(freq[i] == 0){
                    continue;
                }

                int subset = 0, x = i;
                boolean check = true;
                for(int j = 0; j < PRIMES.length; ++j){
                    int prime = PRIMES[j];
                    if(x % (prime * prime) == 0) {
                        check = false;
                        break;
                    }
                    if(x % prime == 0) {
                        subset |= (1<<j);
                    }
                }
                if(!check)
                    continue;

                for(int mask = (1<<PRIMES.length) - 1; mask > 0; --mask) {
                    if((mask & subset) ==subset) {
                        f[mask] = (int)((f[mask] + ((long)f[mask^subset]) * freq[i]) % MOD);
                    }
                }
            }
            int ans = 0;
            for(int mask = 1, maskMax=(1 << PRIMES.length); mask < maskMax; ++mask) {
                ans = (ans + f[mask]) % MOD;
            }
            return ans;
        }

    }



    public static void main(String Args[]) {

        int[] array = {1,2,3,4};
        Solution solution = new Solution();
        int res = solution.numberOfGoodSubsets(array);
        System.out.println(res);


    }

}
