class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: nums)
            pq.add(i);
        
        while(k>0) {
            int temp = pq.poll();
            ans += temp;
            if(temp%3==0)
                pq.add(temp/3);
            else
                pq.add(temp/3+1);
            k--;
        }
        return ans;
    }
}