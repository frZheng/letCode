package offer;

//web https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof

import java.util.*;

public class ziFuChuanDePaiLieLcof {
    private static class Solution {

        public Solution() {
        }


        public String[] permutation(String s) {
            Set<String> list = new HashSet<>();
            char[] arr = s.toCharArray();
//            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[arr.length];
            dfs(arr, "", visited, list);
            return list.toArray(new String[0]);
        }

        public void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
        {
            if(s.length() == arr.length)
            {
                list.add(s);
                return;
            }
            for(int i=0; i<arr.length; i++)
            {
                if(visited[i]) continue;
                visited[i] = true;
                dfs(arr, s+String.valueOf(arr[i]), visited, list);
                visited[i] = false;
            }
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String num = "abc";
        String[] lists = solution.permutation(num);
        for (String i : lists)
            System.out.println(i);

    }

}
