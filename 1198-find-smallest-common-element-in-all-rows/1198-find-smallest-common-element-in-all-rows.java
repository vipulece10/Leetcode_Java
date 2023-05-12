class Solution {
    public int smallestCommonElement(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for(int res : mat[0]){
            int target = res;
            boolean found = true;
            for(int i = 1;i<rows;i++){
                if(!binarySearch(mat[i],target)){
                    found = false;
                    break;
                }
            }
            if(found)
                return res;
        }
        return -1;
    }
    
    private boolean binarySearch(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}