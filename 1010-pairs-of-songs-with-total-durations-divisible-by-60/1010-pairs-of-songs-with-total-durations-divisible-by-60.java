class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i =0;i<time.length;i++){
            int rem = time[i] % 60;
            if(map.containsKey(60 - rem)){
                count += map.get(60-rem) ;
            }
            if(rem == 0){
                map.put(60,map.getOrDefault(60,0)+1);
            }else{
                map.put(rem,map.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }
}