class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int[] count = new int[26];
        int dist = 0;
        for(int i=0;i<tasks.length;i++){
            if(count[tasks[i] - 'A'] == 0) dist++;
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int i=25;
        while(i > 0 && count[i] == count[25]) i--;
        return Math.max(tasks.length, (count[25]-1)*(n+1) + 25 - i);
        
    }
}