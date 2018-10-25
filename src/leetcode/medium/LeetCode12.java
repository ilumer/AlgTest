package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilumer
 * Date : 2018/10/25
 * Time : 9:22 AM
 * https://leetcode.com/problems/integer-to-roman/
 * 没有啥意思的一道题 = = 不过我的方法也真的是很差
 */
public class LeetCode12 {
    public String initToRoman(int num){
        //  0<num<4000
        StringBuilder builder = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        int[] array = new int[]{
          1000,500,100,50,10,5,1
        };
        int n = 0;
        for (int i = 0;i<array.length;i=i+2){
            if (num>=array[i]){
                n = num / array[i];
                num = num % array[i];
                if (n == 9 ){
                   builder.append(map.get(array[i])).append(map.get(array[i-2]));
                }else if(n == 4){
                    builder.append(map.get(array[i])).append(map.get(array[i-1]));

                } else {
                    if (n >= 5){
                        n = n -5;
                        builder.append(map.get(array[i-1]));
                    }
                    for (int j = 0; j < n; j++) {
                        builder.append(map.get(array[i]));
                    }
                }
            }
        }
        return builder.toString();
    }
}
