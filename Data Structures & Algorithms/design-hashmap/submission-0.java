class MyHashMap {
    private static final int SIZE = 10000;
    private LinkedList<Entry>[] buckets;
    
    // Inner class to store key-value pairs
    private static class Entry {
        int key;
        int value;
        
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        
        // Check if key exists, update value
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        
        // Key doesn't exist, add new entry
        buckets[index].add(new Entry(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }
        
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        
        // Find and remove the entry
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                buckets[index].remove(entry);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */