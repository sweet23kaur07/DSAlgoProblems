
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
public static void main(String args[] ) throws Exception {
    Scanner scan = new Scanner(System.in);
    Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
    int count = 0;
    int no = scan.nextInt();
    int test = scan.nextInt();
    while(test > 0){
        int n = scan.nextInt();
        if(map.get(n) == null){
            map.put(n, 1);
        }else{
        	 int val = map.get(n);
             map.put(n, val+1);
        }
       
        
        test--;
    }
    Set<Entry<Integer, Integer>> entrySet = map.entrySet();
Iterator<Entry<Integer, Integer>> itr = entrySet.iterator();
while(itr.hasNext()){
	Entry<Integer, Integer> entry = itr.next();
	int key = entry.getKey();
	int val = entry.getValue();
	int v  = no - key;
//	System.out.println("For Kry : Value : getting val = " + key + " : " + val + ": " + v + " : " + map.get(v));
	if(map.get(v) != null && map.get(v) != 0){
		if(v == key && val == 1){
			continue;
		}
		count++;
		System.out.println(key + " : " + v);
		int mapVal = map.get(v);
		map.put(v, mapVal-1);
		int mapValForKey = map.get(key);
		map.put(key, mapValForKey - 1);
//		System.out.println("New map key : value :" + v + " : " + (mapVal-1) + " -- " + key + " : " + (mapValForKey - 1));
	}
}
    
    System.out.println(count);
}
}
