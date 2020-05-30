package leetcode.medium;

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

    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("3[a]2[bc]"));
    }
}
