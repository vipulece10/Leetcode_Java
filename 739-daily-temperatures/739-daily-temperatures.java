class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<Integer>();
        int [] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                    int x = st.pop();
                    res[x] = i-x;
                }
            st.add(i);
        }
        
        return res;
        
    }
}