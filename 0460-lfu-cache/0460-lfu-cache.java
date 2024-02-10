class LFUCache {
    //https://youtu.be/OUIw_OtgdTo
    Map<Integer,Integer> keyValueMap = new HashMap<Integer,Integer>();
    Map<Integer,Integer> keyFrequencyMap = new HashMap<Integer,Integer>();
    Map<Integer,LinkedHashSet<Integer>>frequencyKeyMap = new HashMap<>();
    int min = 1;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        frequencyKeyMap.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)){
             return -1;
        }
           
        
        //get the freq of the the key
        int freq = keyFrequencyMap.get(key);
        //remove the key from previous frequency
        frequencyKeyMap.get(freq).remove(key);
        //update min if the freq is equal to min and there is no element at the min freq
        if(freq == min && frequencyKeyMap.get(freq).size() == 0){
            min++;
        }
        //create a placeholder if the updated freq doesn't exist in frequencyKeyMap
        if(!frequencyKeyMap.containsKey(freq+1)){
            frequencyKeyMap.put(freq + 1,new LinkedHashSet<>());
        }
        //update the values in frequencyKeyMap && keyFrequencyMap
        frequencyKeyMap.get(freq + 1).add(key);
        keyFrequencyMap.put(key,freq+1);
        return keyValueMap.get(key);
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0)
            return;
        // if key exists in keyValueMap
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key,value);
            get(key);
            return;
        }
        
        //if cache size is equal to capacity
        //get the top key from the min frequency from frequencyKeyMap
        if(keyValueMap.size() >= capacity){
            int keyToBeEvicted = frequencyKeyMap.get(min).iterator().next();
            frequencyKeyMap.get(min).remove(keyToBeEvicted);
            keyFrequencyMap.remove(keyToBeEvicted);
            keyValueMap.remove(keyToBeEvicted);
        }
        
        keyValueMap.put(key,value);
        keyFrequencyMap.put(key,1);
        min = 1;
        frequencyKeyMap.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */