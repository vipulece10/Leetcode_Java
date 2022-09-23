class Solution {
    public long numberOfWays(String s) {
    int n=s.length();
        int [] zero = new int[n];
        int [] one = new int[n];
        int z=0,o=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')  z++;
            else o++;
            zero[i] = z;
            one[i] = o;
        }
        long ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                ans += one[i]*(o-one[i]); 
            }else{
                ans += zero[i]*(z-zero[i]); 
            }
        }
        return ans; 
    
    }
}