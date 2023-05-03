class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0;int j = 0;
        int length = Integer.MIN_VALUE;
        
        while(j < s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
           while(map.size() > 2){
               if(map.get(s.charAt(i)) > 1){
                   map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
               }else{
                   map.remove(s.charAt(i));
               }
               i++;
           }
            length = Math.max(length,j-i+1);
            j++;
        }
        return length;
    }
}