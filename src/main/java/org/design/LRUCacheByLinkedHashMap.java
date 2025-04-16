package org.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheByLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final int capacity;

    public LRUCacheByLinkedHashMap(int capacity) {
        super(capacity, DEFAULT_LOAD_FACTOR, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


	public static void main(String[] args) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("232", 2123);
	}
}
