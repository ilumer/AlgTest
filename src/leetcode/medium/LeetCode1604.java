package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author banxuan
 * Date : 2023/2/7
 * Time : 13:19
 */
public class LeetCode1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int length = keyName.length;
        Map<String, ArrayDeque<String>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String key = keyName[i];
            String time = keyTime[i];
            ArrayDeque<String> timeDeque = map.get(key);
            if (timeDeque == null) {
                timeDeque = new ArrayDeque<>();
                map.put(key, timeDeque);
            }
            String first = timeDeque.peek();
            while (first != null && !isInOneHour(first, time)) {
                timeDeque.poll();
                first = timeDeque.peek();
            }
            timeDeque.add(time);

        }

        return map.entrySet()
                .stream().filter(k -> k.getValue().size() >= 3).map(k -> k.getKey()).sorted().collect(Collectors.toList());
    }

    public static boolean isInOneHour(String a, String b) {
        String[] aArray = a.split(":");
        String[] bArray = b.split(":");
        int aHour = Integer.parseInt(aArray[0]);
        int aMinute = Integer.parseInt(aArray[1]);
        int bHour = Integer.parseInt(bArray[0]);
        int bMinute = Integer.parseInt(bArray[1]);
        if (bHour - aHour < 0) {
            return false;
        }
        if (bHour - aHour == 0) {
            return true;
        }
        if (bHour - aHour == 1 && bMinute <= aMinute) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        new LeetCode1604().alertNames(keyName, keyTime);
    }
}
