class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        /*
        coins = [1,4,10], target = 19
                 i
        coins = [1,4,10]
        curr = 1,
       // https://leetcode.com/problems/minimum-number-of-coins-to-be-added/discuss/4356100/C%2B%2B-or-PYTHON-or-JAVA-oror-Greedy-Explained-oror
        */
        Arrays.sort(coins);
        int count = 0;
        int currMax = 0;
        int idx = 0;
        while(currMax < target){
            if(idx < coins.length && coins[idx] <= currMax + 1){
                currMax += coins[idx];
                idx++;
            }
            else{
                currMax += currMax+1;
                count++;
            }
            
        }
        return count;
        
    }
}