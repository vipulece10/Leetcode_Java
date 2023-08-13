class Solution {
    public String smallestSubsequence(String s) {
        int[] tally = new int[26];
        Set<Character> inUse = new HashSet<>();
        for (char ch : s.toCharArray()) {
            tally[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.isEmpty()) {
                sb.append(ch);
                tally[ch - 'a']--;
                inUse.add(ch);
            } else if (sb.charAt(sb.length() - 1) > ch && !inUse.contains(ch)) {
                while (!sb.isEmpty() && tally[sb.charAt(sb.length() - 1) - 'a'] > 0 && sb.charAt(sb.length() - 1) > ch) { 
                   inUse.remove(sb.charAt(sb.length() - 1));
                   sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(ch);
                tally[ch - 'a']--;
                inUse.add(ch);
            } else if (sb.charAt(sb.length() - 1) < ch && !inUse.contains(ch)) {
                sb.append(ch);
                tally[ch - 'a']--;
                inUse.add(ch);
            } else {
                tally[ch - 'a']--;
            }
        }
        return sb.toString();
    }
}