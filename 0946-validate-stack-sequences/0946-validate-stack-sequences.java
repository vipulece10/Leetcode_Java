class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for(int num : pushed){
            st.add(num);
            while(index < popped.length && !st.isEmpty() && popped[index] == st.peek()){
                st.pop();
                index++;
            }
        }
        return st.isEmpty();
    }
}