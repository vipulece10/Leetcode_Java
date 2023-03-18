class TimeMap {
     Map<String,List<Pair<String,Integer>>> map;
    public TimeMap() {
       map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Pair<String,Integer>>lst = map.get(key);
            lst.add(new Pair<String,Integer>(value,timestamp));
            map.put(key,lst);
        }
        else{
             List<Pair<String,Integer>>list = new ArrayList<>();
            list.add(new Pair<String,Integer>(value,timestamp));
            map.put(key,list);
        }
        
    }
    
    public String get(String key, int timestamp) {
         String res = "";
        if(map.containsKey(key)){
             List<Pair<String,Integer>> lst = map.get(key);
             // int low = lst.get(0).getValue();
             // int high = lst.get(lst.size() - 1).getValue();
            int low = 0;
            int high = lst.size()-1;
             while(low <= high){
             int mid = low+(high-low)/2;
                 if(lst.get(mid).getValue() <= timestamp){
                     res = lst.get(mid).getKey();
                     low = mid + 1;
                 }
                 else{
                     high = mid -1;
                 }
             }
            
        }
       return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */