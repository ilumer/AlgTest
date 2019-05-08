
import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by ilumer
 * Date : 2019-05-03
 * Time : 13:37
 * https://weibo.com/1560442584/Hss9zEc7p?filter=hot&root_comment_id=0&type=comment#_rnd1556874552332
 */
public class DiffResult {
    public boolean areSame;
    public String expected;
    public String Actual;

    public DiffResult(boolean areSame, String expected, String actual) {
        this.areSame = areSame;
        this.expected = expected;
        Actual = actual;
    }

    //不去修改可迭代的接口
    public static DiffResult SortedDiff(Iterable<String> expected,
                                        Iterable<String> actual) {
        List<String> outPutExpected = new ArrayList<>();
        List<String> outPutActual = new ArrayList<>();
        boolean areSame = true;
        Iterator<String> expectedIterator = expected.iterator();
        Iterator<String> actualIterator = actual.iterator();
        // expected,actual 不为null
        String tempExpected = expectedIterator.next();
        String tempActual = actualIterator.next();
        while (expectedIterator.hasNext() && actualIterator.hasNext()) {
            if (tempActual.compareTo(tempExpected) == 0) {
                outPutActual.add(tempActual);
                outPutExpected.add(tempExpected);
                tempExpected = expectedIterator.next();
                tempActual = actualIterator.next();
            } else if (tempActual.compareTo(tempExpected) < 0) {
                outPutExpected.add(collectChar(tempActual.length(), '-'));
                outPutActual.add(tempActual);
                tempActual = actualIterator.next();
                areSame = false;
            } else {
                outPutExpected.add(tempExpected);
                outPutActual.add(collectChar(tempExpected.length(), '-'));
                tempExpected = expectedIterator.next();
                areSame = false;
            }
        }
        if (tempActual.compareTo(tempExpected) > 0){
            outPutExpected.add(tempExpected);
            outPutActual.add(collectChar(tempExpected.length(), '-'));
            outPutActual.add(tempActual);
            outPutExpected.add(collectChar(tempActual.length(), '-'));
            areSame = false;
        }else if (tempActual.compareTo(tempExpected) < 0){
            outPutExpected.add(collectChar(tempActual.length(), '-'));
            outPutActual.add(tempActual);
            outPutActual.add(collectChar(tempExpected.length(), '-'));
            outPutExpected.add(tempExpected);
            areSame = false;
        }else {
            outPutExpected.add(tempExpected);
            outPutActual.add(tempActual);
        }

        while (expectedIterator.hasNext()) {
            areSame = false;
            outPutExpected.add(expectedIterator.next());
        }

        while (actualIterator.hasNext()) {
            areSame = false;
            outPutActual.add(actualIterator.next());
        }
        return new DiffResult(
                areSame, String.join(",", outPutExpected), String.join(",", outPutActual)
        );
    }

    public static void main(String[] args) {
        List<String> expected = Lists.newArrayList("A", "CCC", "EEEEE", "FFFFFF");
        List<String> actual = Lists.newArrayList("BB", "DDDD", "EEEEE");
        DiffResult diffResult = SortedDiff(expected, actual);
        System.out.println(diffResult.areSame);
        System.out.println(diffResult.expected);
        System.out.println(diffResult.Actual);
    }

    public static String collectChar(int length, char c) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = c;
        }
        return new String(chars);
    }
}
