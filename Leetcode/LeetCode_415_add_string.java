class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum, carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i>=0 && j>=0){
            sum = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry;
            sb.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        while(i>=0){
            sum = Character.getNumericValue(num1.charAt(i)) + carry;
            sb.append(sum%10);
            carry = sum/10;
            i--; 
        }
        while(j>=0){
            sum = Character.getNumericValue(num2.charAt(j))  + carry;
            sb.append(sum%10);
            carry = sum/10;
            j--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}