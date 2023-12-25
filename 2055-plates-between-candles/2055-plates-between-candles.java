class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        /*
             0  1  2  3  4  5  6  7  8  9
        s = "*  *  |  *  *  |  *  *  *  |"
        l = -1 -1 -1  2  2 -1  5  5  5  -1
        r =  2  2 -1  5  5 -1  9  9  9  -1
        
        https://youtu.be/4Ch3Zt5qGeA
        */
        int[] ans = new int[queries.length];
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] plates = new int[s.length()];
        int leftSeen = -1;
        for(int i = 0;i<left.length;i++){
            if(s.charAt(i) == '|'){
                leftSeen = i;
            }
            left[i] = leftSeen;  
        }
        
        int rightSeen = -1;
        for(int i = right.length - 1;i >= 0;i--){
            if(s.charAt(i) == '|'){
                rightSeen = i;
            }
            right[i] = rightSeen;  
        }
        
        int numPlates = 0;
        for(int i = 0;i<plates.length;i++){
            if(s.charAt(i) == '*'){
                numPlates++;
            }
            plates[i] = numPlates;  
        }
        
        int k = 0;
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            int count = 0;
            int rightCandle = right[start];
            int leftCandle = left[end];
            
            if(leftCandle == -1 || rightCandle == -1){
                ans[k] = 0;
            }else{
                int d = leftCandle - rightCandle;
                if(d > 0){
                    ans[k] = plates[leftCandle] - plates[rightCandle];
                }else{
                    ans[k] = 0;
                }
            }
            k++;
        }
        return ans;
    }
}