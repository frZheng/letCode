package offer;

//web https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof

public class fanZhuanDanCiShunXuLcof {
    private static class Solution {

        public Solution() {
        }

//        public String reverseWords(String s) {
//            // 先清空中间的字符?
//            int len = s.length();
//            int i;
//
//            for (i = len - 1; i >= 0; --i) {
//                if(s.charAt(i) != ' ')
//                    break;
//            }
//            int suffixIndex = i + 1;
//
//            for (i = 0; i < len; ++i) {
//                if(s.charAt(i) != ' ')
//                    break;
//            }
//            int prefixIndex = i;
//
//            String result = "";
//            int lastIndex = suffixIndex;
//            for (i = suffixIndex; i > prefixIndex; --i) {
//                if (i < len-1)
//                    if (s.charAt(i) == ' ' ){
//                        if(s.charAt(i + 1) != ' ') {
//                            result += s.substring(i + 1, lastIndex);
//                            result += " ";
//                        }
//                        lastIndex = i;
//                    }
//            }
//            if (prefixIndex < lastIndex)
//                result += s.substring(prefixIndex, lastIndex);
//            return result;
//        }
        public String reverseWords(String s) {
            //将传进来的字符串以空格拆分
            String[] strings = s.trim().split(" ");
            StringBuffer stringBuffer = new StringBuffer();
            //从尾巴开始遍历
            for (int i = strings.length - 1; i >= 0; i--) {
                if (strings[i].equals("")) {
                    continue;
                }
                //到头了，append然后去空格
                if (i == 0) {
                    stringBuffer.append(strings[i].trim());
                } else {
                    // 怕有多余的空格，去掉，再加上去
                    stringBuffer.append(strings[i].trim()).append(" ");
                }
            }
            //输出String 完事，安排！
            return stringBuffer.toString();
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
//        String lists = solution.reverseWords("the sky is blue");
//        String lists = solution.reverseWords(" the    sky    is    blue  ");
        String lists = solution.reverseWords("");
//        String lists = solution.reverseWords("  the sky is blue   ");
        System.out.println(lists);

    }

}
