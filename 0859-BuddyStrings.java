class Solution {
    int[] alpha = new int[26];
    int[] beta = new int[26];
    int numOfUniqLetters = 0;
    public boolean buddyStrings(String A, String B) {
        if(A==null || B==null || A.length() < 2 || B.length() <2 || A.length()!=B.length()) {
            return false;
        }

        int diff = 0;
        for(int i =0; i< A.length(); i++) {
            int c = A.charAt(i) - 'a';
            if(alpha[c] ==0) {
                numOfUniqLetters++;
            }
            alpha[c]++;

            c = B.charAt(i) - 'a';
            beta[c]++;

            if(A.charAt(i)!=B.charAt(i)) {
                diff++;
            }
        }

        if(A.equals(B)) {
            if(numOfUniqLetters < A.length()) {
                return true;
            } else {
                return false;
            }
        }

        for(int i =0; i< alpha.length; i++) {
            if(alpha[i] != beta[i]) {
                return false;
            }
        }
        
        return diff<=2;
    }
}
