class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,j=0;
       Map<Integer,Integer> hmap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while(j < fruits.length){  
            hmap.put(fruits[j],j);
            if(hmap.size() <= 2){
                 max = Math.max(max,j-i+1);
                j++;
            }
            else if(hmap.size() > 2){
                 int min = Integer.MAX_VALUE; 
                for(int val : hmap.values()){
                    min = Math.min(min,val);
                }
                 hmap.remove(fruits[min]);
                    i= min + 1;
            }
        }
        return max;
    }
}