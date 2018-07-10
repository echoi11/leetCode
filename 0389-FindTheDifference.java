class Solution {
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];
        if(s.equals("")) {
            return t.charAt(0);
        }
        for(int i=0; i< s.length(); i++) {
            a[s.charAt(i) -'a']++;
        }
        char c;
        for(int i=0; i < t.length(); i++) {
            c = t.charAt(i);
            a[c - 'a']--;
            if(a[c - 'a']==-1) return c;
        }
        return ' ';
    }
}
