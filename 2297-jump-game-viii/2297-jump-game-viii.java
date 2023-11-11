class Solution {
    public long minCost(int[] nums, int[] costs) {
        int[] nextGreater = new int[nums.length];
        int[] nextSmaller = new int[nums.length];
        long[] dp = new long[nums.length];
        
        Arrays.fill(nextGreater,-1);
        Arrays.fill(nextSmaller,-1);
        Arrays.fill(dp,Long.MAX_VALUE);
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                int idx = st.pop();
                nextGreater[idx] = i;
            }
            st.add(i);
        }
        
        st.clear();
        
        for(int i = 0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                int idx = st.pop();
                nextSmaller[idx] = i;
            }
            st.add(i);
        }
        
        dp[0] = 0;
        for(int i = 0;i<nums.length;i++){
           if(nextGreater[i] != -1){
               dp[nextGreater[i]] = Math.min(costs[nextGreater[i]]+dp[i],dp[nextGreater[i]]);
           }
           
           if(nextSmaller[i] != -1){
               dp[nextSmaller[i]] = Math.min(costs[nextSmaller[i]]+dp[i],dp[nextSmaller[i]]);
           } 
        }
        
        // for(int i = 0;i< dp.length;i++){
        //     System.out.println("nextGreater : " + nextGreater[i]);
        //      System.out.println("nextSmaller : " + nextSmaller[i]);
        //      System.out.println("dp : " + dp[i]);
        //}
        
        
        return dp[dp.length-1];
    }
}