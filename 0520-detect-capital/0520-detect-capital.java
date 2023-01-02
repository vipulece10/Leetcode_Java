class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1)
            return true;
        boolean match1 = true;
        boolean match2 = true;
        boolean match3 = true;
        
        //All capital letters
        for(int i=0;i<word.length();i++){
            if(Character.isLowerCase(word.charAt(i))){
                match1 = false;
                break;
            }        
        }
        //All lower case letters
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                match2 = false;
                break;
            }        
        }
        
        //only the first letter in the word is capital
        boolean firstletter = Character.isUpperCase(word.charAt(0));
        if(firstletter){
            for(int i=1;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                match3 = false;
                break;
            }        
        }
        }else{
            match3 = false;
        }
        
        if(match1 || match2 || match3)
            return true;
        else
            return false;
        
        
    }
}