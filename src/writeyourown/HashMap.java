package writeyourown;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Custom implementation of hash based Map data structure, which implements the contract
 * of {@link Map}
 * @author santhosh
 *
 * @param <K> - type of key
 * @param <V> - type of value
 */
public class HashMap<K, V> implements Map<K, V> {
	
	/**
	 * A class which holds the key-value pair together. It is also a linked-list
	 * which comes handy in case of hash collision
	 * @author santhosh
	 *
	 * @param <K> - type of key
	 * @param <V> - type of value
	 */
	public static class Entry<K, V> implements java.util.Map.Entry<K, V> {
		
		private K key;
		
		private V value;
		
		private Entry<K, V> next;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		@Override
		public String toString() {
			return key + " - " + value;
		}
		
 	}
	
	//the hash buckets which helps to retrieve / add the data @ O(1) time complexity
	private Entry<K, V>[] hashArr;
	
	//loadFactor tells how much percentage the Hash bucket can get filled, before it needs to be resized
	private float loadFactor = 0.75f;
	
	//total elements in the map
	private int size = 0;
	
	//single object of keySet, values and EntrySet per map - since they reflects the Keys, Values or Entries of map enclosing it, 
	//only single instance is sufficient
	private KeySet keySet;
	private Values values;
	private EntrySet entrySet;
	
	/**
	 * Default HashMap constructs bucket of 16 elements
	 */
	public HashMap() {
		this(16);
	}
	
	/**
	 * HashMap which gets initialized with initial capacity
	 * @param initialCapacity - with which the map buckets needs to be created
	 */
	@SuppressWarnings("unchecked")
	public HashMap(int initialCapacity) {
		this.hashArr = new Entry[initialCapacity];
	}
	
	/**
	 * HashMap which gets initialized with initial capacity and form factor
	 * @param initialCapacity - with which the map buckets needs to be created
	 * @param loadFactor % of buckets allowed to get filled, after which resize happens
	 */
	@SuppressWarnings("unchecked")
	public HashMap(int initialCapacity, float loadFactor) {
		this.hashArr = new Entry[initialCapacity];
		this.loadFactor = loadFactor;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private int hashIndex(Object key) {
		return key.hashCode() % (this.hashArr.length - 1);
	}
	
	private Object findKey(Entry<K, V> entry, Object key) {
		for(Entry<K, V> e = entry; e != null; e = e.next) {
			if(e.key.equals(key)) {
				return e.key;
			}
		}
		return null;
	}
	
	@Override
	public boolean containsKey(Object key) {
		if(key == null) {
			return false;
		}
		Entry<K, V> entry = this.hashArr[hashIndex(key)];
		if(entry == null) {
			return false;
		}
		if(entry.key == key) {
			return true;
		}
		return findKey(entry, key) != null;
	}


	@Override
	public boolean containsValue(Object value) {
		for(int i=0; i<this.hashArr.length; i++) {
			Entry<K, V> e = this.hashArr[i];
			for(Entry<K, V> next = e; next != null; next = next.next) {
				if(next.value == value || value != null && value.equals(next.value)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		Entry<K, V> entry = this.hashArr[hashIndex(key)];
		return entry != null ? entry.value : null;
	}

	@Override
	public V put(K key, V value) {
		Objects.requireNonNull(key, "Key cannot be null");
		Entry<K, V> entry = this.hashArr[hashIndex(key)];
		if(entry != null) {
			//key is already present in the hashMap. Update the value
			V prevValue = entry.value;
			entry.value = value;
			return prevValue;
		} else {
			ensureCapacity();
			Entry<K, V> e = new Entry<>(key, value);
			this.hashArr[hashIndex(key.hashCode())] = e;
			size++;
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if(size >= loadFactor * this.hashArr.length) {
			int newSize = this.hashArr.length + (int) (this.hashArr.length * loadFactor); 
			
			System.out.println("HashMap size(" + size + ")vhas reached the loadFactor. Resizing to new Size -"+newSize);
			//rehash
			Entry<K, V>[] oldArr = this.hashArr;
			this.hashArr = new Entry[newSize];
			size = 0;
			int i = 0;
			for(;i<oldArr.length;) {
				Entry<K, V> c;
				if((c = oldArr[i++]) != null) {
					put(c.key, c.value);
					while(c.next != null) {
						c = c.next;
						put(c.key, c.value);
					}
				}
			}
		}
	}

	@Override
	public V remove(Object key) {
		if(key == null) {
			return null;
		}
		int index = hashIndex(key.hashCode());
		Entry<K, V> entry = this.hashArr[index];
		if(entry == null) {
			return null;
		}
		this.hashArr[index] = null;
		size--;
		return entry.value;
	}
	

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		for(int i=0; i<this.hashArr.length; i++) {
			this.hashArr[i] = null;
		}
		this.size = 0;
	}

	@Override
	public Set<K> keySet() {
		if(this.keySet == null) {
			this.keySet = new KeySet();
		}
		return this.keySet;
	}

	@Override
	public Collection<V> values() {
		if(this.values == null) {
			this.values = new Values();
		}
		return this.values;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		if(this.entrySet == null) {
			this.entrySet = new EntrySet();
		}
		return this.entrySet;
	}
	
	

	@Override
	public String toString() {
		String s = "HashMap [ ";
		for(Iterator<Map.Entry<K, V>> i = entrySet().iterator(); i.hasNext();) {
			Map.Entry<K, V> e = i.next();
			s += e.toString() + ",";
		}
		s += " ]";
		return s;
	}



	private class KeySet extends AbstractSet<K> {
		
		@Override
		public final boolean contains(Object key) {
			return containsKey(key);
		}

		@Override
		public final boolean remove(Object key) {
			return HashMap.this.remove(key) != null;
		}

		@Override
		public void clear() {
			HashMap.this.clear();
		}

		@Override
		public Iterator<K> iterator() {
			return new KeyItr();
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	private class EntrySet extends AbstractSet<java.util.Map.Entry<K,V>> {
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean contains(Object o) {
			if(o instanceof Entry) {
				Entry<K, V> e = (Entry<K, V>) o;
				return HashMap.this.containsKey(e.getKey());
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean remove(Object o) {
			if(o instanceof Entry) {
				Entry<K, V> e = (Entry<K, V>) o;
				return HashMap.this.remove(e.getKey()) != null;
			}
			return false;
		}

		@Override
		public void clear() {
			HashMap.this.clear();
		}

		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			return new EntryItr();
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	private class Values extends AbstractCollection<V> {

		@Override
		public boolean contains(Object value) {
			return containsValue(value);
		}

		@Override
		public void clear() {
			HashMap.this.clear();
		}

		@Override
		public Iterator<V> iterator() {
			return new ValItr();
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	private class KeyItr extends HashMapItr implements Iterator<K> {

		@Override
		public K next() {
			return nextNode().key;
		}
		
	}
	
	private class ValItr extends HashMapItr implements Iterator<V> {

		@Override
		public V next() {
			return nextNode().value;
		}
		
	}
	
	private class EntryItr extends HashMapItr implements Iterator<Map.Entry<K, V>> {

		@Override
		public Entry<K, V> next() {
			return nextNode();
		}
		
	}
	
	private abstract class HashMapItr {
		
		private Entry<K, V> current;
		
		private Entry<K, V> next;
		
		private int index = 0;
		
		HashMapItr() {
			for(; index < hashArr.length;) {
				if((next = hashArr[index++]) != null) {
					break;
				}
			}
		}

		public boolean hasNext() {
			return next != null;
		}

		public Entry<K, V> nextNode() {
			current = next;
			next = next.next;
			if(next == null) {
				for(; index < hashArr.length;) {
					if((next = hashArr[index++]) != null) {
						break;
					}
				}
			}
			return current;
		}

		public void remove() {
			Entry<K, V> c = current;
			HashMap.this.remove(c.key);
			current = null;
		}
		
	}

}
