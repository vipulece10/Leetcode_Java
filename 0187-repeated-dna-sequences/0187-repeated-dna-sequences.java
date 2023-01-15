class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> dna_freq = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(s.length() < 10)
            return new ArrayList<>();
        for(int i =0;i<=s.length()-10;i++){
            String seq = s.substring(i,i+10);
            if(!dna_freq.containsKey(seq)){
                dna_freq.put(seq,1);
            }else{
                dna_freq.put(seq,1+dna_freq.get(seq));
            }
        }
        
        for(String key : dna_freq.keySet()){
            if(dna_freq.get(key) > 1){
                res.add(key);
            }
        }
        
        return res;
    }
}