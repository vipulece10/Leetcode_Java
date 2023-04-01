class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || list.isEmpty()){
            return false;
        }
        int indexToRemove = map.get(val);
        int valueToRemove = val;
        int lastIndex = list.size()-1;
        int lastIndexValue = list.get(lastIndex);

        if(indexToRemove == lastIndex){
            // Remove last index
            list.remove(indexToRemove);
            map.remove(valueToRemove);
            return true;
        }

        // Remove last index
        list.remove(lastIndex);
        map.remove(lastIndexValue);
        // Remove current index
        list.remove(indexToRemove);
        map.remove(valueToRemove);
        // Insert the last index at current
        list.add(indexToRemove, lastIndexValue);
        map.put(lastIndexValue, indexToRemove);
        return true;
        
    }
    
    public int getRandom() {
       return list.get(((int)(Math.random()*(list.size()))));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */