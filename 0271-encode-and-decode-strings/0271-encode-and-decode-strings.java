public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String element : strs){
            str.append(element.length() + "/"+ element);
        }
        System.out.println(str.toString());
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List <String> res = new ArrayList<>();
        int index;
        int length;
        int i =0;
        while(i < s.length()){
           index=s.indexOf('/',i);
           
           if(Character.isDigit(s.charAt(index-1))){
               length = Integer.valueOf(s.substring(i,index));
               res.add(s.substring(index+1,index+length+1));
               i = index+length+1;
           } 
           else{
             i++;   
           }   
           
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));