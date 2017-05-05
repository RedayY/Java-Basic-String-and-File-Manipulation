import java.util.Map;
import java.util.HashMap;
/*
 * ----------------------------
 * Reday Ahmad Yahya
 * Student ID: M00531154
 * E-Mail: ry106@live.mdx.ac.uk
 * ----------------------------
 */

public class hashmap {
public static void main(String args[]){
      
    
      String sa= "When most I wink then do mine eyes best see For all the day they view things unrespected But when I sleep in dreams they look on thee And darkly bright are bright in dark directed Then thou whose shadow shadows doth make bright How would thy shadows form form happy show To the clear day with thy much clearer light When to unseeing eyes thy shade shines so How would I say mine eyes be blessed made By looking on thee in the living day When in dead night thy fair imperfect shade Through heavy sleep on sightless eyes doth stay All days are nights to see till I see thee And nights bright days when dreams do show thee me";
      String s = sa.toUpperCase();
      String[] splitted = s.split(" ");
      
      
      
      
      HashMap hm = new HashMap();
      int x;

      for (int i = 0; i < splitted.length; i++) {
            if (!hm.containsKey(splitted[i])) {
                hm.put(splitted[i], 1);
            } else {
                hm.put(splitted[i], (Integer) hm.get(splitted[i]) + 1);
            }
        for (Object word : hm.keySet()){
            System.out.println(word + " " + (Integer) hm.get(word));   
        }
        
      }
       System.out.printf("%n");
      // System.out.println(getKeyFromValue(hm , 4) );
      
}

//Fetchest Key from value
  public static Object getKeyFromValue(Map hm, Object value) {
    for (Object o : hm.keySet()) {
      if (hm.get(o).equals(value)) {
        return o;
      }
    }
    return null;
  }
}

        

