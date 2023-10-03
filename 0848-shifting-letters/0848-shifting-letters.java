class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        /*
        s = "abc", shifts = [3,5,9]
        a-> 3 times
        a,b-> 5 times
        a,b,c -> 9 times    [a-> 17 times,b-> 14 times,c->9 times]
        
        sum = 17;
        
        shifts = [3,5,9]
        */
        
        char[] arr = s.toCharArray();
        int shift = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            arr[i] = (char)((arr[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(arr);
    }
}