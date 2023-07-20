class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        /*
              [ 10, 2, -5]     st [10]  -5
        
        */
        Stack<Integer> st = new Stack<>();
       
        
        for(int i =0;i<asteroids.length;i++){
              boolean isAdded = true;
            while(!st.isEmpty() && (st.peek() > 0 && asteroids[i] < 0)){
               
                //case 1 top < asteroid
                if(Math.abs(st.peek()) < Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                
                //case 2 top == asteroid
                else if(Math.abs(st.peek()) == Math.abs(asteroids[i])){
                    st.pop();
                     isAdded = false;
                    break;
                }
                
                //case 3 top > asteroid
                else{
                isAdded = false;
                break;
                }    
            }
            
            
            if(isAdded)
                st.add(asteroids[i]);
            
        }
        
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }
        
        return remainingAsteroids;
    }
}