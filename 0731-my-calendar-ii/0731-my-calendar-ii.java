class MyCalendarTwo {
    // ArrayList<int[]> dob = new ArrayList<>();
    ArrayList<int[]> single;
    ArrayList<int[]> dob;
    public MyCalendarTwo() {
        single = new ArrayList<>();
        dob = new ArrayList<>();;
    }
    
    public boolean book(int start, int end) {
        for(int i[]: dob) {
            if(Math.max(start,i[0]) < Math.min(end,i[1]))
                return false;
        }
        for(int i[]: single) {
            if(Math.max(start,i[0])<Math.min(end,i[1])) {
                dob.add(new int[]{Math.max(start,i[0]),Math.min(end,i[1])});
            }
        }
        single.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */