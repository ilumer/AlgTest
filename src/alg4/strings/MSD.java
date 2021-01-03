package alg4.strings;


import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by ilumer
 * Date : 2018/7/15
 * Time : 下午7:01
 * https://algs4.cs.princeton.edu/51radix/words3.txt
 * java-alg4 MSD < input.txt
 */
public class MSD {

    private static int R = 256;

    /**
     * 小数组的切换阙值
     */
    private static final int M = 15;
    /**
     * 辅助数组
     */
    private static String[] aux;

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    public static int charAt(String str, int index) {
        if (index > str.length() - 1) {
            return -1;
        }
        return str.charAt(index);
    }

    /**
     * @param a    需要排序的数组
     * @param low  需要排序的起始位置
     * @param high 数组的末尾位置
     * @param d    代表的是字符串中的index 第几个字符
     */
    private static void sort(String[] a, int low, int high, int d) {
        // 需要加入一个阙值，在小于这个阙值时不在递归的使用sort 直接使用插入排序，减少了额外的性能损耗
        if (low + M >= high) {
            insertion(a,low,high,d);
            return;
        }
        //最初的位置代表的是不符合长度要求的字符串(太短了
        int[] count = new int[R + 2];
        for (int i = low; i <= high; i++) {
            //第d个位置的字符
            // charAt 返回的是 char -> int
            //charAt(a[i],d)+2 -> -1+2=1 代表的是长度过于短的部分的数量
            //                    0+2=2 代表的是在排序最靠前的字符的数量
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) {
            // count[r+1] 到表的是 第r个字符已经之前的字符占的数量(包括太短的部分
            count[r + 1] += count[r];
        }

        for (int i = low; i <= high; i++) {
            // 数据分类 根据前面生成的频率部分，再把各个string放到对应的位置，相同charAt(a[i],d) + 1部分暂时是无法排序的
            // count[charAt(a[i], d) + 1]++ 相当于把 count[charAt(a[i], d) + 1] 的值往后移动了，
            // 这样aux的index也就变大了
            // 相当于同一个桶里面是一个链表，将节点定位到最后一个位置
            // 为什么这里是加+1 但是上面却是加+2了    主要时是频率与索引转化造成这个变化
            // 将频率转为变索引时,count[k-1]的结束位置就是count[k]的开始位置
            // count[k]的最后填满时的位置 就是之前的频率的值
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = low; i <= high; i++) {
            //回写
            // 回写的部分只能保证在这个key下面的部分是有序的
            // i-low前的部分不属于维护的范围
            a[i] = aux[i - low];
        }

        for (int r = 0; r < R; r++) {
            // 相同字符下的子数组重新再排序
            // count[r] 在count[r]的值已经变动后 原本的count[r+1]的起始值已经变成了count[r]的结束值
            // count[r + 1] - 1 这里的减1 是因为这最后一次多加了1
            // 相当于将一个大数组切分成很多个小数组
            // 大数组在d个的char是一样的
            sort(a, low + count[r], low + count[r + 1] - 1, d + 1);
        }
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        sort(a);
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}
