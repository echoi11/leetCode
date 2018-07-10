class Solution {
    public int numJewelsInStones(String J, String S) {
        int [] j = new int[128];
        int result =0;
        for(int i = 0; i < J.length(); i++) {
            j[J.charAt(i)] = 1;
        }
        for(int i=0; i < S.length(); i++) {
            if(j[S.charAt(i)]==1) {
                result++;
            }
        }
        return result;
    }
}
