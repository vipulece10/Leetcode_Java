class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        HashMap<String,List<Integer>> map = new HashMap<>();
        for(int i =0;i<keyName.length;i++){
            if(map.containsKey(keyName[i])){
                List<Integer> lst = map.get(keyName[i]);
                lst.add(getTimeInMinutes(keyTime[i]));
                map.put(keyName[i],lst);
            }else{
                 List<Integer> lst = new ArrayList<Integer>();
                lst.add(getTimeInMinutes(keyTime[i]));
                //int val = getTimeInMinutes(keyTime[i]);
                map.put(keyName[i],lst);
            }
            // map.computeIfAbsent(keyName[i], g -> new ArrayList<>());
            // map.get(keyName[i]).add(getTimeInMinutes(keyTime[i]));
        }
        System.out.println(map.size());
        for(String key : map.keySet()){
            List<Integer> lstTime = map.get(key);
            Collections.sort(lstTime);
            int n = lstTime.size();
            System.out.println(n);
            for(int i =2;i<n;i++){
                if((lstTime.get(i) - lstTime.get(i-2)) <= 60){
                    res.add(key);
                    break;
                }
            }
        }
        Collections.sort(res);
       return res; 
    }
    public int getTimeInMinutes(String timeStamp){
        String [] tokens = timeStamp.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }
}