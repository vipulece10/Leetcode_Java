class Solution {
    public String validIPAddress(String IP) {
        boolean isIpv4 = isValidIpv4(IP);
        boolean isIpv6 = isValidIpv6(IP);
        if(isIpv4)
            return "IPv4";
        else if(isIpv6)
            return "IPv6";
        else
            return "Neither";
        
    }
    
    private boolean isValidIpv4(String IP){
         System.out.println(IP);
         if(!IP.contains("."))
            return false;
        if(IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.')
            return false;
       
        String[] tokens = IP.split("\\.");
        System.out.println(tokens.length);
        if (tokens.length != 4)
            return false;
        for (String token : tokens) {
            int val=0;
            try{
                 val = Integer.parseInt(token);
            } catch (Exception e){
                return false;
            }
            
            if(val < 0 || val > 255)
                return false;
            if(token.length() > 1 && token.charAt(0) =='0')
                return false; 
        }
        return true;
    }
    
    private boolean isValidIpv6(String IP){
        
        if(!IP.contains(":"))
            return false;
        if(IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':')
            return false;
        String validation = "0123456789abcdefABCDEF";
        String [] tokens = IP.split("\\:");
        System.out.println(tokens.length);
        if (tokens.length != 8)
            return false;
        for(String token : tokens){
            System.out.println(token.length());
            if(token.length() > 4 || token.length() <  1){
                return false;
            }
            for(int i=0;i<token.length();i++){
                // if(Character.isAlphabetic(token.charAt(i))){
                // if((Character.toLowerCase(token.charAt(i)) - 'a') > 6 ){
                //      System.out.println(token.charAt(i));
                //     return false;
                // }
                // }
                if(!validation.contains(String.valueOf(token.charAt(i))))
                    return false;
            }
        }
        return true;
    }
    
    
}