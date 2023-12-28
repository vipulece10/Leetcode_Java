class Pair{
    int length;
    String Word;
    public Pair(int length,String Word){
        this.length = length;
        this.Word = Word;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Create a set and put words in it
        Set <String> set = new HashSet<>(); 
        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);
        //Create a priority Queue of Pair and sort them in ascending order
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b)->a.length - b.length);
        pq.add(new Pair(0,beginWord));
        // Queue<Pair> pq = new LinkedList<>();
        // pq.add(new Pair(0,beginWord));

        while(!pq.isEmpty()){
            Pair word_pq = pq.poll();
            String word_process = word_pq.Word;
            if(word_process.equals(endWord))
                return word_pq.length + 1;
            for(int i = 0;i < word_process.length();i++){
                for(char j = 'a'; j <='z'; j++){
                    char [] replacedCharArray = word_process.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = String.valueOf(replacedCharArray);
                    if(set.contains(replacedWord)){
                        System.out.println("replacedWord" + replacedWord);
                        set.remove(replacedWord);
                        pq.add(new Pair(word_pq.length + 1,replacedWord));
                    }
                }
            }
        }
        return 0;
        
    }
}