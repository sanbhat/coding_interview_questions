package writeyourown;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 */
public class FastDS<T> {

    private Map<T, Integer> map = new HashMap<>();

    private List<T> arr = new ArrayList<>();

    public FastDS() {

    }

    public void add(T item) {
        if(map.containsKey(item)) {
            return;
        }
        int size = arr.size();
        arr.add(item);
        map.put(item, size);
    }

    public void delete(T item) {
        if(!map.containsKey(item)) {
            return;
        }
        int index = map.get(item);
        map.remove(item);
        T last = arr.get(arr.size()-1);
        Collections.swap(arr, index, arr.size()-1);
        arr.remove(arr.size()-1);
        map.put(last, index);
    }

    public T random() {
        Random r  = new Random();
        int i = r.nextInt(arr.size());
        return arr.get(i);
    }

    public static void main(String[] args) {
        FastDS<Integer> ds = new FastDS<>();
        ds.add(1);
        ds.delete(1);
    }
}
