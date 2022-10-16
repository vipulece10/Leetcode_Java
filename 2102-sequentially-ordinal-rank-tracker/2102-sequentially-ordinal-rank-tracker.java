class SORTracker {

    /**
    https://leetcode.com/problems/sequentially-ordinal-rank-tracker/discuss/1632156/Two-Heaps
    */
    private PriorityQueue<Pair> minPq;
    private PriorityQueue<Pair> maxPq;

    public SORTracker() {
        this.minPq = new PriorityQueue<>();
        this.maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void add(String name, int score) {
        Pair pair = new Pair(score, name);
        minPq.add(pair);
        maxPq.add(minPq.poll());
    }

    public String get() {
        Pair pair = maxPq.poll();
        minPq.add(pair);
        return pair.name;
    }

    private static class Pair implements Comparable<Pair> {
        int score;
        String name;

        Pair(int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.score == o.score)
                return o.name.compareTo(this.name);
            return this.score - o.score;
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */