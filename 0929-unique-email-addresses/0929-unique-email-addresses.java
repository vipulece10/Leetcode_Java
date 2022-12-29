class Solution {
    public int numUniqueEmails(String[] emails) {
        Set <String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            String [] names = email.split("@");
            String local = names[0];
            String domain = names[1];
            int index_plus = local.indexOf("+",0);
            System.out.print("index" + index_plus);
            if(index_plus != -1){
                local=local.substring(0,index_plus);
            }
            int index_dot = local.indexOf(".",0);
            if(index_dot != -1){
               local =local.replace(".","");
            }
            //System.out.println("local" + local);
            //System.out.println("domain" + domain);
            set.add(new String(local + "@"+ domain));
        }
        return set.size();
    }
}