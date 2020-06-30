package leetcode.medium;


import java.util.Stack;

/**
 * @author banxuan
 * Date : 2020/5/29
 * Time : 1:36 上午
 * https://leetcode-cn.com/problems/decode-string/
 */
public class LeetCode394 {
    static class indexPair{
        private String str;
        private int index;

        public indexPair(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    public indexPair decodeString(String s,int index) {
        int repeatNum = 0;
        StringBuilder builder = new StringBuilder();
        while (index<s.length()){
            if (Character.isDigit(s.charAt(index))){
                repeatNum = repeatNum * 10 + Character.digit(s.charAt(index),10);
            }else if (s.charAt(index)=='['){
                //需要decode新的string
                StringBuilder temp = new StringBuilder();
                indexPair indexPair = decodeString(s, index + 1);
                String str =  indexPair.str;
                index = indexPair.index;
                while (repeatNum>0){
                    temp.append(str);
                    repeatNum--;
                }
                builder.append(temp);
            }else if (s.charAt(index)==']'){
                break;
            }else {
                builder.append(s.charAt(index));
            }
            index++;
        }
        return new indexPair(builder.toString(),index);
    }

    public String decodeString(String s) {
        return decodeString(s,0).str;
    }

    /**
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decode-string
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        Stack<StringBuilder> resStack = new Stack<>();
        Stack<Integer> multiStack =  new Stack<>();
        int multi =  0;
        StringBuilder res = new StringBuilder();
        for (char c :s.toCharArray()){
            if (Character.isDigit(c)){
                multi = multi * 10 + c -'0';
            }else if (c =='['){
                resStack.add(res);
                multiStack.add(multi);
                res = new StringBuilder();
                multi = 0;
            }else if (c ==']'){
                Integer pop = multiStack.pop();
                StringBuilder temp = new StringBuilder();
                while (pop>0){
                    temp.append(res);
                    pop--;
                }
                StringBuilder pre = resStack.pop();
                res = new StringBuilder(pre.toString()+temp);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString2("3[a]2[bc]").equals("aaabcbc"));
        System.out.println(new LeetCode394().decodeString2("3[a2[c]]").equals("accaccacc"));
        System.out.println(new LeetCode394().decodeString2("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
    }
}
