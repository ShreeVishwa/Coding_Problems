class Solution {
    public int calculate(String s) {
        int num = 0;
        Stack<Integer> st = new Stack<Integer>();
        char sign = '+';
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) num = num*10 + s.charAt(i) - '0';
            if(i == s.length()-1 || (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')){
                if(sign == '-') st.push(-num);
                else if(sign == '+') st.push(num);
                else if(sign == '*') st.push(st.pop()*num);
                else if(sign == '/') st.push(st.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        System.out.println(st);
        int res = 0;
        for(int i: st){
            res += i;
        }
        return res;
    }
}