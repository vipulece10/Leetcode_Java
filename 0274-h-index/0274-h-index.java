class Solution {
    public int hIndex(int[] citations) {
        
        /*
        citations = [3,0,6,1,5]
                     0 1 2 3  4
        low = 0,
        high = 5
        
        mid = 2 
        
        checkCitations true
        low = mid+1; 3
        high = 5
        
        11,15
        mid = 1
        */
        
        int low = 0;
        int high = citations.length;
        int result = 0;
        
        while(low <= high){
            int mid = high + (low - high)/2;
            if(checkCitations(citations,mid)){
                result = mid;
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return result;
    }
    
    public boolean checkCitations(int[]citations,int mid){
        int count = 0;
        for(int i=0;i<citations.length;i++){
            if(citations[i] >= mid)
                count++;
        }
        return count >= mid;
    } 
}