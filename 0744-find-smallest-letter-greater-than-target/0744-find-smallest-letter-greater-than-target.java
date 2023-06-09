class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0;
        int high = letters.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((letters[mid] - target) > 0){
                high = mid -1;                
            }else{
                low = mid + 1;
            }
        }
        return  low == n ? letters[0] : letters[low];
    }
}