class Solution {
    public int maximumLengthSubstring(String s) {
        
        if (s == null || s.length() == 0)
            return 0;
            // Shrink the window if the current window violates the constraint
            int i=0;
            int j =0;
            int maxLength = 0;
            Map<Character, Integer> windowCount = new HashMap<>();
            
            while (j < s.length()) {
                char leftChar = s.charAt(j);
                if(!windowCount.containsKey(leftChar) || (windowCount.get(leftChar) < 2)){
                     windowCount.put(leftChar, windowCount.getOrDefault(leftChar, 0) + 1);
                    maxLength = Math.max(maxLength,j-i + 1);
                    j++;
                }else{
                    windowCount.put(s.charAt(i), windowCount.get(s.charAt(i)) - 1); 
                    if (windowCount.get(s.charAt(i)) == 0)
                    windowCount.remove(s.charAt(i));
                i++;
                }
            }
        return maxLength;
    }
}