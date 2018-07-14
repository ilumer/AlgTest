package alg4.strings;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer
 * Date : 2018/6/23
 * Time : 下午8:15
 * test file: https://algs4.cs.princeton.edu/50strings/pi.txt
 *              https://algs4.cs.princeton.edu/50strings/abra.txt
 *  java-algs4 alg4.strings.Count ABCDR0123456789. < ../../../Downloads/pi.txt
 * 计算文件中字符出现的次数(忽视不存在alphabet中的情况)
 */
public class Count {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet(args[0]);
        int R = alphabet.R();
        int[] count = new int[R];

        String s = StdIn.readAll();
        int N = s.length();
        for (int i =0; i < N; i++){
            //需要检查是否包含这个字符，否则会抛出异常
            if (alphabet.contains(s.charAt(i)))
                count[alphabet.toIndex(s.charAt(i))]++;
        }
        for (int i =0; i < R;i++){
            StdOut.println(alphabet.toChar(i)+":"+count[i]);
        }
    }
}
