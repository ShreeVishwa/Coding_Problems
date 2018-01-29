class Solution {
    
    public int sum(int n){
        int s = 0;
        while(n>0){
            int c = n%10;
            n = n/10;
            s += Math.pow(c,2);
        }
        return s;
    }
    
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int s = sum(n);
        while(s != 1){
            // System.out.println(s);
            if(list.contains(s)) return false;
            else{
                list.add(s);
                s = sum(s);
            }
        }
        return true;
    }
}

// A much better solution without using any space complexity

class Solution {
    
    public int sum(int n){
        int s = 0;
        while(n>0){
            int c = n%10;
            n = n/10;
            s += Math.pow(c,2);
        }
        return s;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        } while(slow!=fast);
        if(slow == 1) return true;
        else return false;
    }
}

