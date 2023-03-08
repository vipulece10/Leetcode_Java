class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int element : arr){
            set.add(element);
        }
        
        int i = 1;
        while(k > 0){
            if (!set.contains(i)){
                k--;
            }
           i++;     
        }
        return i-1;
    }
}