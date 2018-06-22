class Solution {
    public int lengthOfLongestSubstring(String s) { //abcabcbb
        int[] tally = new int[128];
        int streak = 0;
        int maxStreak = 0;
        int tallyIndex = 0;
        int minIndex = 0;
        for(int i =0; i < s.length(); i++) { //0; 1; 2; 3
            char c = s.charAt(i); //a; b; c; a
            tallyIndex = c + 0;//- 'a'; // 0; 1; 2; 0
            if(tally[tallyIndex] > minIndex) {
                minIndex = tally[tallyIndex]; //0
                streak = i + 1 - minIndex; // 3; 3-0;
                tally[tallyIndex] = i + 1;
                continue;
            } else {
                // remember we are adding 1 to input s index
                streak ++; // 1; 2; 3
                if(streak > maxStreak) { //
                    maxStreak = streak; // 3
                }
                tally[tallyIndex] = i + 1; // t[0]=1, t[1]=2, t[2]=3
            }
        }
        return maxStreak;
    }
    
}
