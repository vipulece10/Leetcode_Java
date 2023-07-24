class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        /*
        1,5,7,8,5,3,4,2,1           diff = -2
                                    arr[i] - diff
        */
        int longestVal = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i] - difference)){
                map.put(arr[i],1+map.get(arr[i] - difference));
            }else{
                map.put(arr[i],1);
            }
        }
        
        for(int key : map.keySet()){
            longestVal = Math.max(longestVal,map.get(key));
        }
        
        return longestVal;
    }
}