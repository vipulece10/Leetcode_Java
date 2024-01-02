class Solution {
    /*
    https://leetcode.com/problems/analyze-user-website-visit-pattern/discuss/355606/Java-Very-Easy-Understand-With-Explanation
    */
    class Pair{
        String website;
        int timestamp;
        public Pair(String website,int timestamp){
            this.website = website;
             this.timestamp = timestamp;
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
       Map<String,List<Pair>> visitedMap = new HashMap<>();
       Map<String,Integer>countMap = new HashMap<>();
       String res = "";
       
       for(int i = 0;i<username.length;i++){
           visitedMap.putIfAbsent(username[i],new ArrayList<>());
           visitedMap.get(username[i]).add(new Pair(website[i],timestamp[i]));
       }
        
       for(String key : visitedMap.keySet()){
            //System.out.println(key);
           List<Pair> lst = visitedMap.get(key);
           
           Set<String> set = new HashSet<>();
           Collections.sort(lst,(a,b) -> a.timestamp - b.timestamp);
            //System.out.println(lst);
           for(int i = 0;i<lst.size();i++){
               for(int j = i+1;j<lst.size();j++){
                   for(int k = j+1;k<lst.size();k++){
                       String str = lst.get(i).website + " " + lst.get(j).website + " " + lst.get(k).website;
                      // System.out.println(str);
                       if(!set.contains(str)){
                           countMap.put(str,countMap.getOrDefault(str,0) + 1);
                           set.add(str);
                       }
                       if(res.equals("") || countMap.get(res) < countMap.get(str) || (countMap.get(res) == countMap.get(str) && res.compareTo(str) > 0)){
                           res = str;
                       }
                   }
               }
           }
       }
        
        List<String> ans = new ArrayList<>();
        
        String[] resultTokens = res.split(" ");
        for(String token : resultTokens){
            ans.add(token);
        }
        return ans;
    }
}