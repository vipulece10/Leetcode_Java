class Solution {
    public int[] findArray(int[] pref) {
        /*
        Input: pref = [5,2,0,3,1]
         5 Xor 7 = 2 -> 2 x 5->7 x->NOT AND ->!&
        Output: [5,7,2,3,2]   ans ^ 2
Explanation: From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.   [101 ^ 
                          111]
                           0 1 0   
                           0 0 1
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
        
        
        */
        int []  res = new int[pref.length];
        res[0] = pref[0];
        
        for(int i =1;i<pref.length;i++){
            res[i] = pref[i] ^ pref[i-1];
        }
        return res;
        
    }
}