class Solution {
    public int minOperations(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums)
            pq.add(i);
        int count = 0;
        while(pq.size()>1 && pq.peek()<k) {
            int x = (int)pq.poll();
            int y = (int)pq.poll();
            int z = x*2 +y;
            if(z<0) pq.add(Integer.MAX_VALUE);
            else
                pq.add(z);
            count++;
        }
        return count;
        
    }
}