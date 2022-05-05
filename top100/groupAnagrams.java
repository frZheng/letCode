package top100;

 //web https://leetcode-cn.com/problems/group-anagrams


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  groupAnagrams {
    private static class Solution {

        public Solution() {
        }


        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,ArrayList<String>> map=new HashMap<>();
            for(String s:strs){
                char[] ch=s.toCharArray();
                Arrays.sort(ch);
                String key=String.valueOf(ch);
                if(!map.containsKey(key))
                    map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }
            return new ArrayList(map.values());
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> arr1 : lists) {
            StringBuilder msg = new StringBuilder();
            for (String i : arr1){
                msg.append(i).append(",");
            }
            System.out.println(msg);
        }


    }
}
