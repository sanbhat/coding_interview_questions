package writeyourown;

import java.util.Iterator;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>(); 
		for(int i=1; i<=26; i++) {
			map.put(i, String.valueOf((char)('a' - i)));
		}
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		for(Iterator<Integer> i = map.keySet().iterator(); i.hasNext();) {
			if(i.next().equals(3)) {
				i.remove();
			}
		}
		System.out.println("KeySet after removing 3 using Iterator.remove() call - "+map.keySet());
	}

}
