class Solution {

    char a1;
    char a2;
    char b1;
    char b2;
    boolean isSame = false;
    int numOfUniq=0;
    int [] alpha = new int[26];
    
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()) {
            return false;
        }
        
        if(A.length() < 2) {
            return false;
        }
        
        // do this check in for loop
//         if(A.equals(B)) {
//             isSame = true;
//         }
        
        // if more than 2 letters are different => false
        // if 2 or less, but the letters are not the same => false
        // if 2 or less, same letters and more than 2 letters are the same, true
        
        int diffPos=0;
        
        for(int i=0; i < A.length(); i++) {
            char a = A.charAt(i);
            if(alpha[a - 'a'] == 0 ) {
                alpha[a - 'a']++;
                numOfUniq++;
            }

            if(A.charAt(i)!=B.charAt(i)) {
                if(diffPos == 2) {
                    return false;
                }
                if(diffPos==0) {
                    a1 = A.charAt(i);
                    b1 = B.charAt(i);
                } else {
                    a2 = A.charAt(i);
                    b2 = B.charAt(i);
                }
                diffPos++;
            }
        }
        
        if(diffPos==0) {
            if(numOfUniq < A.length()) {
                return true;
            }
        } else if(diffPos==2) {
            if(a1==b2 && a2==b1) {
                return true;
            }
        }
        return false;
        
        
    }
}
