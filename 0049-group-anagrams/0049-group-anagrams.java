class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList <List<String>> res=new ArrayList<>();
        HashMap <String,List<String>> map=new HashMap<>();
        
        for(String str:strs){
            char [] charcount=new char[26];
            int i=0;
            while(i<str.length()){
                charcount[str.charAt(i)-'a']++;
                i++;
            }
            String key=String.valueOf(charcount);
            // List <String> list=new ArrayList<>();
            // if(!map.containsKey(key)){
            //     list.add(str);
            //     map.put(key,list);
            // }else{
            //     list=map.get(key);
            //     list.add(str);
            //     map.put(key,list);
            // }
            map.computeIfAbsent(key,g->new ArrayList<String>());
            map.get(key).add(str);
        }
        
         for(List<String> element: map.values()){
             res.add(element);
             }
        
        return res;
       // return new ArrayList(map.values());
        
    }
}