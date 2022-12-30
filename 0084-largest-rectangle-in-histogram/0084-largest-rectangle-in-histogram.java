class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int [] left = new int[n];
        int [] right = new int[n];
        
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = 0;
            }
            else{
            left[i] = st.peek() + 1;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n-1;
            }
            else{
            right[i] = st.peek() - 1;
            }
            st.push(i);
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(right[i] - left[i] +1));
        }
        
        return max;
    }
}