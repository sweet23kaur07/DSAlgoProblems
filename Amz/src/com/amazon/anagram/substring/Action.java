package com.amazon.anagram.substring;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Action {

	public static void main(String[] args) {
		String action  = "action";
		String test = "ctoi";
		boolean res = anagram(action, test);
		System.out.println(res);
	}

	public static boolean anagram(String text, String pattern){
		//put pattern it in a map
		int len = pattern.length();
		final int MAX_ENTRY = len;
		Map<String, Integer> patternMap = new HashMap();
		for(int i=0; i < len; i++){
			String key = pattern.substring(i, i+1);
			if(patternMap.get(key) == null){
				patternMap.put(key, 1);
			}else{
				int val = patternMap.get(key);
				patternMap.put(key, val+1);
			}
		}
		
		LinkedHashMap<String, Integer> textMap = new LinkedHashMap<String, Integer>(MAX_ENTRY, 0.75F, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
				return size() > MAX_ENTRY;
			}
		};
		
		int count = 1;
		boolean matched = false;
		for(int i = 0; i < text.length(); i++){
			String ch = text.substring(i,i+1);
			if(textMap.get(ch) != null){
				textMap.put(ch, textMap.get(ch)  +1);
			}else{
				textMap.put(ch, 1);
			}
			
			if(count == len){
				count--;
				for(Entry<String, Integer> entry : textMap.entrySet()){
					String key = entry.getKey();
					Integer value = entry.getValue();
					if(patternMap.get(key) == null){
						matched = false;
						break;
					}else{
						if(value.equals(patternMap.get(key))){
							matched = true;
							continue;
						}
					}
				}
			}
			if(matched){
				System.out.println("Pattern anagram found");
				break;
			}
			count++;
			matched = false;
		}
		return matched;
	}
}
