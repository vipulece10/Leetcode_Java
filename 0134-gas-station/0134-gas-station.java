class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;
        if(len==1) return gas[0]>=cost[0] ? 0 : -1;
		
        int start=0,end=1;
        int currFuel=gas[start]-cost[start];
        while(start<len)
        {
            while(currFuel>=0)
            {
                currFuel+=gas[end]-cost[end];
                end=(end+1)%len;
                // completed the circle
                if (end == start && currFuel >= 0) return start;
            }
            while(currFuel < 0 && start < len)
            {
                currFuel-=gas[start]-cost[start];
                //currFuel=0;
                start++;
            }
        }
        return -1;
        
    }
}