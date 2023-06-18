class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // https://leetcode.com/problems/the-latest-time-to-catch-a-bus/discuss/2259320/Greedy-Solution-oror-Java
        int ans = 0,j =0;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<buses.length;i++){
            int c = 0;
            while(j < passengers.length && c< capacity && passengers[j] <= buses[i]){
                if(!set.contains(passengers[j] - 1))
                    ans = passengers[j] - 1;
                set.add(passengers[j]);
                j++;c++;
            }
            if(c < capacity && !set.contains(buses[i])){
                ans = buses[i];
            }
        }
        
        return ans;
    }
}