class Solution {
    public String simplifyPath(String path) {
        String[] ans = path.split("/");
        // for(int i=0;i<ans.length;i++) System.out.println(ans[i].length());
        Deque<String> st = new LinkedList<String>();
        for(int i=0;i<ans.length;i++){
            if(ans[i].length() == 0 || (ans[i].length() == 1 && ans[i].charAt(0) == '.')) continue;
            else if(ans[i].length() == 2 && ans[i].charAt(0) == '.' && ans[i].charAt(1) == '.'){
                if(!st.isEmpty()) st.removeLast();
            } 
            else st.addLast(ans[i]);
        }
        String res = "";
        Iterator iterator = st.iterator();
        while (iterator.hasNext())
            res = res + "/" + iterator.next();
        if(res.length() == 0) res += "/";
        return res;
    }
}