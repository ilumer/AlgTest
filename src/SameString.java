import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilumer on 17-5-23.
 * 如果两个字符串中的每个字符的数目都相等，就认为两个字符相等
 */
public class SameString {
  public boolean isSameString(String a,String b){
    if (a.length() != b.length()) return false;

    Map<Character,Integer> mapA = new HashMap<>();
    Map<Character,Integer> mapB = new HashMap<>();

    for (int i = 0 ; i <a.length();i++){
      putKeyValue(mapA,a.charAt(i));
      putKeyValue(mapB,b.charAt(i));
    }

    for (Character c:mapA.keySet()){
      if (!mapA.get(c).equals(mapB.get(c))){
        return false;
      }
    }
      return true;
   }

   public void putKeyValue(Map<Character,Integer> map,Character Key){
     if (map.containsKey(Key)){
       map.put(Key,map.get(Key)+1);
     }else {
       map.put(Key,1);
     }
   }
}
