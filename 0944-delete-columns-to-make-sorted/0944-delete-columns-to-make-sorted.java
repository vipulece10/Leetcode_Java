class Solution {
    public int minDeletionSize(String[] strs) {
        int count =0;
        int m = strs.length;
        int n = strs[0].length();
        
        for(int i =0;i<n;i++){
            for(int j=1;j<m;j++){
                if(strs[j].charAt(i) - strs[j - 1].charAt(i) < 0){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}