package top100;

//web https://leetcode-cn.com/problems/valid-parentheses


import java.util.ArrayList;
import java.util.Stack;

public class   validParentheses {
    private static class Solution {

        public Solution() {
        }

        public boolean isValid(String s) {
            if ((s.length() & 0x01) == 0x01)return false;
            Stack<Character>stack = new Stack<Character>();
            for(char c: s.toCharArray()){
                if(c=='(')stack.push(')');
                else if(c=='[')stack.push(']');
                else if(c=='{')stack.push('}');
                else if(stack.isEmpty()||c!=stack.pop())
                    return false;
            }
            return stack.isEmpty();
//            if ((s.length() & 0x01) == 0x01)return false;
//            ArrayList<Integer> chars = new ArrayList<Integer>();
//
//            for (int i = 0; i < s.length(); ++i) {
//                chars.add((int)s.charAt(i));
//            }
//            int mid;
//            while (chars.size() > 0) {
//                mid = chars.size() /2;
//                if( chars.get(mid - 1) == '(' && chars.get(mid) == ')' ||
//                    chars.get(mid - 1) == '{' && chars.get(mid) == '}' ||
//                    chars.get(mid - 1) == '[' && chars.get(mid) == ']'
//                    ) {
//                    //必须先删除大的
//                        chars.remove(mid);
//                        chars.remove(mid - 1);
//                }
//                else if(mid - 2 > 0 && (
//                        chars.get(mid - 2) == '(' && chars.get(mid - 1) == ')' ||
//                        chars.get(mid - 2) == '{' && chars.get(mid - 1) == '}' ||
//                        chars.get(mid - 2) == '[' && chars.get(mid - 1) == ']')
//                ) {
//                    chars.remove(mid - 1);
//                    chars.remove(mid - 2);
//
//                }else if(mid + 1 < chars.size() && (
//                        chars.get(mid) == '(' && chars.get(mid + 1) == ')' ||
//                        chars.get(mid) == '{' && chars.get(mid + 1) == '}' ||
//                        chars.get(mid) == '[' && chars.get(mid + 1) == ']')
//                ) {
//                    chars.remove(mid + 1);
//                    chars.remove(mid);
//                }
//                else {
//                    return false;
//                }
//            }
//            return true;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();


        boolean lists = solution.isValid( "[({(())}[()])]");
        System.out.println(lists);
    }

}
