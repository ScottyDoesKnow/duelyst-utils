package sdk.utility;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://stackoverflow.com/a/2581754
public class MapUtil {
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return sortByValue(map, new Comparator<Map.Entry<K, V>>() {
	        @Override
	        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
	            return (o1.getValue()).compareTo(o2.getValue());
	        }
	    });
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
	    return sortByValue(map, new Comparator<Map.Entry<K, V>>() {
	        @Override
	        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });
	}
	
	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
	    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
	    Collections.sort(list, comparator);
	
	    Map<K, V> result = new LinkedHashMap<>();
	    for (Map.Entry<K, V> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
}
