package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapRunner {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		
		map.put("mins", 85);
		map.put("adam", 90);
		map.put("Ranga", 70);
		map.put("mins", 90);
		
		System.out.println("Entry counts : " + map.size());
		
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> ketIterator = keySet.iterator();
		while (ketIterator.hasNext()) {
			String k = ketIterator.next();
			Integer v = map.get(k);
			System.out.println(k + " " + v);
		}
		System.out.println();
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		Iterator<Entry<String,Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + " " + v);
		}
		System.out.println();

		map.remove("mins");
		System.out.println("Entry counts : " + map.size());
		System.out.println();
		

	}

}
