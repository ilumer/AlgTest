package alg4.strings;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quick3String {
    public static int charAt(String str, int index) {
        if (index > str.length() - 1) {
            return -1;
        }
        return str.charAt(index);
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    /**
     * @param a    需要排序的数组
     * @param low
     * @param high
     * @param d
     */
    private static void sort(String[] a, int low, int high, int d) {
        if (low >= high) {
            return;
        }

        // 用来比较的字符 >v ==v <v
        int lt = low, gt = high;
        int v = charAt(a[low], d);
        int i = low + 1;
        // 需要字符记录当前的位置和 >v <v的指针位置
        while (i <= gt) {
            int str = charAt(a[i], d);
            if (str < v) {
                // i>=lt
                // i->lt 之间的值都是v
                // charAt(a[lt], d) == v
                exch(a, lt++, i++);
            } else if (str > v) {
                // 这里的i是不动的
                // 因为交换过来的值没有遍历过
                exch(a, i, gt--);
            } else if (str == v) {
                i++;
            }
        }
        //a[lo..lt-1] < v = a[lt,gt] < a[gt+1..hi]
        sort(a, low, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, high, d);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // read in the strings from standard input
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // sort the strings
        sort(a);

        // print the results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}
