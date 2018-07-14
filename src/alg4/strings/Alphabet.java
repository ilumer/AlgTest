package alg4.strings;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer
 * Date : 2018/6/10
 * Time : 上午12:52
 */
public class Alphabet {

    /**
     *  The binary alphabet { 0, 1 }.
     */
    public static final Alphabet BINARY = new Alphabet("01");

    /**
     *  The octal alphabet { 0, 1, 2, 3, 4, 5, 6, 7 }.
     */
    public static final Alphabet OCTAL = new Alphabet("01234567");

    /**
     *  The decimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    /**
     *  The hexadecimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F }.
     */
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    /**
     *  The DNA alphabet { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     *  The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     *  The uppercase alphabet { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     *  The protein alphabet { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     *  The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     *  The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     *  The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    /**
     *  The Unicode 16 alphabet (0-65,535).
     */
    public static final Alphabet UNICODE16 = new Alphabet(65536);

    private char[] alphabet;
    private int[] inverse; // indices 指数
    private final int R; // the radix of the alphabet 基数

    public Alphabet(int radix){
        this.R = radix;
        this.alphabet = new char[R];
        this.inverse = new int[R];
        for (int i =0;i<R;i++){
            alphabet[i] = (char) i;
        }

        for (int i = 0; i<R;i++){
            inverse[i] = i;
        }
    }

    public Alphabet(){
        this(256);
    }

    public Alphabet(String s) {
        // unicode的字符集的大小为65536
        //把unicode看作一个是char,boolean类型的map
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("duplicate char is '"+c+"'");
            unicode[c] = true;
        }

        alphabet = s.toCharArray();
        R = alphabet.length;
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++){
            inverse[i] = -1;
        }

        for (int c = 0; c < R; c++){
            inverse[alphabet[c]] = c;
            //在inverse 这个int,int的map中更新在alphabet中出现过的值
            //没有出现过key的值仍然为-1
        }

    }

    /**
     * @param index
     * @return 返回index对应的char
     * @throws IllegalArgumentException unless {@code 0<=index<=R}
     */
    public char toChar(int index){
        if (index<0 || index>R){
            throw new IllegalArgumentException("index must be 0 and "+R+":"+index);
        }
        return alphabet[index];
    }

    /**
     * return true if the char in alphabet;
     * @param c char
     * @return {@code true} if the char in the alphabet else {@code false}
     */
    public boolean contains(char c){
        return inverse[c] != -1;
    }

    /**
     *
     * @return the number of characters in this alphabet
     */
    public int R(){
        return R;
    }

    /**
     *
     * @return the binary logarithm of the number of characters in this alphabet
     */
    public int logR(){
        int lgR = 0;
        // 2^0 = 1
        for (int t = R - 1; t>=1; t/=2){
            lgR++;
        }
        return lgR;
    }

    /**
     *
     * @param s the characters
     * @return the indices corresponding to the characters {@code s}
     * @throws IllegalArgumentException unless every character in {@code s} is a character in
     * alphabet
     */
    public int[] toIndices(String s){
        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for (int i = 0; i < source.length;i++){
            target[i] = toIndex(source[i]);
        }
        return target;
    }

    /**
     *
     * @param c the character
     * @return the index of the character in alphabet {@code 0<=s<R}
     * @throws IllegalArgumentException unless the {@code s} is a character in alphabet
     */
    public int toIndex(char c){
        if (c >= inverse.length || inverse[c] == -1){
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    /**
     *
     * @param indices the indices
     * @return the characters corresponding to the indices {@code indices}
     * @throws IllegalArgumentException unless {@code 0 <= indices[i] <= R} for
     *          every {@code i}
     */
    public String toChars(int[] indices){
        StringBuilder builder = new StringBuilder(indices.length);
        for (int i = 0;i<indices.length;i++){
            builder.append(toChar(indices[i]));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[]  encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        StdOut.println(decoded1);

        int[]  encoded2 = Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
        String decoded2 = Alphabet.DNA.toChars(encoded2);
        StdOut.println(decoded2);

        int[]  encoded3 = Alphabet.DECIMAL.toIndices("01234567890123456789");
        String decoded3 = Alphabet.DECIMAL.toChars(encoded3);
        StdOut.println(decoded3);
    }
}
