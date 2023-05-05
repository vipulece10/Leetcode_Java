class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0;i<cpdomains.length;i++){
            String [] tokens = cpdomains[i].split(" ");
            int val = Integer.parseInt(tokens[0]);
            String domain = tokens[1];
           
            while(domain.indexOf('.') != -1){
                    if(!map.containsKey(domain)){
                        map.put(domain,val);
                    }else{
                        map.put(domain,map.get(domain) + val);
                    }                
                int index = domain.indexOf('.');
                int length = domain.length();
                domain = domain.substring(index+1,length);
            }
           // System.out.println("last domain " + domain);
             if(!map.containsKey(domain)){
                        map.put(domain,val);
                    }else{
                        map.put(domain,map.get(domain) + val);
                    }  
        }
        
        for(String key : map.keySet()){
            int count = map.get(key);
            String str = count + " " + key;
            res.add(str);
        }
        return res;
    }
}