
class Solution {
    public long minNumberOfSeconds(int mh, int[] wt) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[0],b[0]));
        int count = mh;
        long ans = 0L;

        for(int i: wt) {
            pq.add(new long[]{i,i,1});
        }
        
        while(count > 0) {
            long[] temp = pq.poll();
            ans = temp[0];
            pq.add(new long[]{temp[0]+temp[1]*(temp[2]+1),temp[1],temp[2]+1});
            count--;
        }
        return ans;
    }
}