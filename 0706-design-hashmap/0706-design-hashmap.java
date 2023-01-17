class MyHashMap {
    int [] hashMapArray;
    public MyHashMap() {
        hashMapArray = new int [1000000+1];
        Arrays.fill(hashMapArray,-1);
    }
    
    public void put(int key, int value) {
        hashMapArray[key] = value;
    }
    
    public int get(int key) {
        if(hashMapArray[key] != -1)
        return hashMapArray[key];
        else
        return -1;
    }
    
    public void remove(int key) {
        hashMapArray[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */