class Solution {
    public boolean hasAllCodes(String s, int k) {
        //set to store unique substring
        HashSet<String> set = new HashSet<>();
        int i=0,j=0;
        while(j<s.length()){
            if(j-i+1 == k){
                set.add(s.substring(i,j+1));
                i++;
            }
            j++;
        }
        return set.size() == Math.pow(2.0,k*1.0);
    }
}