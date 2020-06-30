package leetcode.easy;

public class LeetCode67 {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int flag = 0;
        StringBuilder result = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int first = 0;
            if (aIndex >= 0) {
                first = Character.getNumericValue(a.charAt(aIndex));
                aIndex--;
            }
            int second = 0;
            if (bIndex >= 0) {
                second = Character.getNumericValue(b.charAt(bIndex));
                bIndex--;
            }
            int c = first + second + flag;
            if (c > 2) {
                flag = 1;
                result.insert(0, (c - 2));
            } else {
                flag = 0;
                result.insert(0, c);
            }
        }
        if (flag != 0) {
            result.insert(0, flag);
        }
        return result.toString();
    }
}
