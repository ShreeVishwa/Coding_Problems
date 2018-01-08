public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode source) {
        if(source == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(source);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        hm.put(source,new UndirectedGraphNode(source.label));
        while(!q.isEmpty()){
            UndirectedGraphNode u = q.poll();
            UndirectedGraphNode cloneGraphU = hm.get(u);
            if(u.neighbors != null){
                List<UndirectedGraphNode> v = u.neighbors;
                for(UndirectedGraphNode node : v){
                    UndirectedGraphNode cloneGraphNodeG = hm.get(node);
                    if(cloneGraphNodeG == null){
                        q.add(node);
                        cloneGraphNodeG = new UndirectedGraphNode(node.label);
                        hm.put(node,cloneGraphNodeG);
                    }
                    cloneGraphU.neighbors.add(cloneGraphNodeG);
                }
            }
        }
        return hm.get(source);
    }
}