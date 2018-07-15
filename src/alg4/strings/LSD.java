package alg4.strings;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer
 * Date : 2018/7/15
 * Time : 下午3:12
 * test : java-algs4 alg4.strings.LSD < words3.txt
 * test file: https://algs4.cs.princeton.edu/51radix/words3.txt
 * output:all
 *        bad
 *        bed
 *        bug
 *        dad
 *        dim
 *        ....
 *        tar
 *        tip
 *        wad
 *        was
 *        wee
 *        yes
 *        yet
 *        zoo
 */
public class LSD {

    private LSD(){

    }
    /**
     * @param a the array to be sorted
     * @param w the number of characters per string
     */
    private static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256; // ascii size
        String[] aux = new String[a.length];
        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];
            //计算频率
            for (int j = 0; j < N; j++) {
                // 这里加一是为了下面计算索引
                count[a[j].charAt(i) + 1]++;
            }

            //计算索引
            for (int j = 0; j < R; j++) {
                count[j + 1] += count[j];
            }

            //将元素分类
            for (int j = 0; j < N; j++) {
                //没有加一的原因在于 max(count[m]) = min(count[m+1])-1
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            //回写
            for (int j = 0; j < N; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        int w = a[0].length();

        for (int i = 0;i<n;i++){
            assert a[i].length() == w: "Strings must have fixed length";
        }
        sort(a, w);
        for (String s:a){
            StdOut.println(s);
        }
    }
}
