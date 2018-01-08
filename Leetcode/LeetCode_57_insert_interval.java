class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int j=0;
        while(j<intervals.size()){
            if(intervals.get(j).start < newInterval.start) j++;
            else break;
        }
        intervals.add(j,newInterval);
        Stack<Interval> st = new Stack<Interval>();
        st.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval out = st.peek();
            if(out.end >= intervals.get(i).start){
                out.end = Math.max(out.end,intervals.get(i).end);
                // System.out.println(out);
                st.pop();
                st.push(out);
            }
            else st.push(intervals.get(i));
        }
        // List<Interval> res = new ArrayList<Interval>();
        // while(!st.isEmpty()){
        //     System.out.println(st.pop());
        // }
        return st;
    }
}