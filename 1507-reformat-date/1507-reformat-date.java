class Solution {
    public String reformatDate(String date) {
        HashMap<String,String> map = new HashMap<>();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
        
        String [] dates = date.split(" ");
        String year = dates[2];
        String month = map.get(dates[1]);
        String day = "";
        if (dates[0].length() == 3){
            day = "0"+dates[0].substring(0,1);
        }else{
            day = dates[0].substring(0,2);
        }
        
        
        return year + "-" + month + "-" + day;
        
    }
}