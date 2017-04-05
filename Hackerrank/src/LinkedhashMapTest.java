import java.util.*;

class LinkedHashMapTest
{
    private static final int MAX_ENTRIES = 5;

	public static void main(String arg[])
    {
      /*  LinkedHashMap<String, String> lhm = new LinkedHashMap(MAX_ENTRIES, 0.75F, true) {

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
         };*/
         LinkedHashMap<String, String> lhm = new LinkedHashMap();
        lhm.put("Ramesh", "Intermediate");
        lhm.put("Shiva", "B-Tech");
        lhm.put("Santosh", "B-Com");
        lhm.put("Asha", "Msc");
        lhm.put("Raghu", "M-Tech");
        
        Set set = lhm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
                
        System.out.println("The value to the corresponding to key : " + lhm.get("Asha")); 
        String val = lhm.get("Ramesh");
        lhm.put("Ramesh", val);
        
        lhm.put("Latest", "M-Tech");
//       Set set1 = lhm.entrySet();
        Iterator i1 = set.iterator();
        while (i1.hasNext()) {
            Map.Entry me = (Map.Entry) i1.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
        
    }
}
