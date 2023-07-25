class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        /*
             0  1  2 3 4 
             [0,10,5,2,1]        mid = 2.     
              i    j   j
              
              if(arr[mid] > arr[mid +1])
              j = mid;
              else
              i = mid + 1;
        */
        
        int low = 0;
        int high = arr.length - 1;
        
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}