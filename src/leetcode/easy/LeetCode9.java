package leetcode.easy;

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        int copy = x;
        int revNum = 0;
        if (x< 0){
            return false;
        }
        while (x != 0) {
            revNum = revNum * 10 + x % 10;
            x = x / 10;
        }
        return revNum == copy;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindrome(121));
    }
}
