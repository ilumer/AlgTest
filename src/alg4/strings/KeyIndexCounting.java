package alg4.strings;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by ilumer
 * <p>
 * Date : 2018/7/14
 * time : 下午11:52
 * java-algs4 alg4.strings.KeyIndexCounting < file
 *  test file: https://algs4.cs.princeton.edu/51radix/words3.txt
 *  output: all	bed	bug	bad	dad
 *          dim	dug	egg	for	few
 *          fee	gig	hut	ilk	jot
 *          jay	joy	jam	men	now
 *          nob	owl	rap	sob	sky
 *          tip	tag	tap	tar	wee
 *          was	wad	yes	yet	zoo
 */
public class KeyIndexCounting {

    public static void main(String[] args) {
        Alphabet alphabet = Alphabet.LOWERCASE;
        String[] values = StdIn.readAllStrings();
        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i],alphabet.toIndex(values[i].charAt(0)));
        }

        //开始计算排序
        int R = alphabet.R();
        int[] count = new int[R+1];
        for (int i = 0; i < values.length; i++) {
            count[items[i].key+1]++;
            //计算频率
        }
        //转换为索引
        for (int i = 0; i < R; i++) {
            count[i+1]+=count[i];
        }

        //需要根据key排序
        Item[] aux = new Item[values.length];
        for (int i =0;i<values.length;i++){
            //items[i].key 得到对于的分组 count[index]得到对应的索引
            // ++ 是为了自增 增加同个分组的index上涨
            aux[count[items[i].key]++] = items[i];
        }

        for (int i=0;i<values.length;i++){
            items[i] = aux[i];
        }

        for (int i = 0; i < items.length; i++) {
            if (i%5==0) {
                System.out.println();
            }
            Item item = items[i];
            System.out.print(item.value+"\t");
        }
    }
}


