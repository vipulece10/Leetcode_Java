class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int maxCount = 0;
        int ans = -1;
        
        if(arr.length == 1)
            return arr[0];
        
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                count++;
                if(count > maxCount){
                    maxCount = count;
                    ans = arr[i];
                }
            }
            else{
                count = 1;
            }
        }
        return ans;
    }
}