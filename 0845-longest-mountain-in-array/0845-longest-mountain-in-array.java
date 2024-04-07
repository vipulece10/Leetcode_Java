class Solution {
    public int longestMountain(int[] arr) {
        /*     0 1 2 3 4 5 6
        arr = [2,1,4,7,3,2,5]
        
        */
        
        int base = 0;
        int maxLength = 0;
        int n = arr.length;
        
        while(base < n){
            int end = base;
            if( end + 1 < n && arr[end] < arr[end + 1]){
                while(end + 1 < n && arr[end] < arr[end + 1]){
                    end++;
                }
                if(end + 1 < n && arr[end] > arr[end + 1]){
                    while(end + 1 < n && arr[end] > arr[end + 1]){
                    end++;
                }
                    maxLength = Math.max(maxLength,end - base + 1);
                }
                
            }
            
            base = Math.max(end,base + 1);
        }
       return maxLength; 
    }
}