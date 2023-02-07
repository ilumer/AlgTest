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
        List<String> result = new ArrayList<>();
        Map<String, List<String>> nameToTime = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> times = nameToTime.computeIfAbsent(name, k -> new ArrayList<>());
            times.add(time);
        }
        for (Map.Entry<String, List<String>> nameToTimeEntry : nameToTime.entrySet()) {
            String name = nameToTimeEntry.getKey();
            List<String> times = nameToTimeEntry.getValue().stream().sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                        String[] aArray = o1.split(":");
                        String[] bArray = o2.split(":");
                        int aHour = Integer.parseInt(aArray[0]);
                        int aMinute = Integer.parseInt(aArray[1]);
                        int bHour = Integer.parseInt(bArray[0]);
                        int bMinute = Integer.parseInt(bArray[1]);
                        // -1 表示 o1 小于02
                        if (aHour!=bHour){
                            return aHour-bHour;
                        }else {
                            return aMinute-bMinute;
                        }
                }
            }).collect(Collectors.toList());
            ArrayDeque<String> timeDeque = new ArrayDeque<>();
            for (String time : times) {
                String first = timeDeque.peek();
                while (first != null && !isInOneHour(first, time)) {
                    timeDeque.poll();
                    first = timeDeque.peek();
                }
                timeDeque.add(time);
                if (timeDeque.size() >= 3 && !result.contains(name)) {
                    result.add(name);
                }
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
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
        System.out.println(new LeetCode1604().alertNames(keyName, keyTime));
    }
}
