public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> st = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i=nestedList.size()-1;i>=0;i--){
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
        
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
            NestedInteger node = st.peek();
            if(node.isInteger()){
                return true;
            }
            st.pop();
            for(int i=node.getList().size()-1;i>=0;i--){
                st.push(node.getList().get(i));
            }
        }
        return false;
    }
}