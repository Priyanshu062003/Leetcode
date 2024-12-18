class TopVotedCandidate {
    Map<Integer,Integer> map = new HashMap<>();
    int[][] pair;
    int n;
    public TopVotedCandidate(int[] persons, int[] times) {
        n = times.length;
        pair = new int[n][2];
        int max = 0, per = -1;

        for(int i=0; i<n; i++) {
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
            if(map.get(persons[i])>=max) {
                per = persons[i];
                max = map.get(persons[i]);
            }
            pair[i][0] = per;
            pair[i][1] = times[i];
        }

    }
    
    public int q(int t) {
        int l = 0, r = n-1;
        while(l<r) {
            int mid = (l+r)/2;
            if(t <= pair[mid][1]) {
                r = mid;
            } 
            else l = mid+1;
        }
        if (l > 0 && pair[l][1] > t) 
            l--;
        // if(pair[l][0] == -1) return tie.get(pair[l][1]);
        return pair[l][0];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */