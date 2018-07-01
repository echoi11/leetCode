//"zzzzzyyyyy"
//["zzyy","zy","zyy"]

class Solution {
    public int expressiveWords(String S, String[] words) {
    	boolean [] exp = new boolean [S.length()];
    	char [] alp = new char [S.length()];
    	int x=0;
    	int len = 0;
        for(int i=0; i < S.length()-1; i++) {
        	alp[x]=S.charAt(i);
        	if(S.charAt(i)==S.charAt(i + 1)) {
        		// find next letter that is different.
        		len = 1;
        		do {
        			len++;
        			i++;
        		} while(i < S.length()-1 && S.charAt(i)==S.charAt(i + 1));
        		if(len > 2) {
        			exp[x] = true;
        			x++;
        		} else {
        			exp[x++] = false;
        			alp[x] = S.charAt(i);
        			exp[x++] = false;
        		}
        	} else {
        		exp[x] = false;
        		x++;
        	}
        }
        System.out.println("exp=" + Arrays.toString(exp))	;
        System.out.println("alp=" + Arrays.toString(alp));
        
        int sol = 0;
        for(int i=0; i < words.length; i++) {
        	if(words[i].length() == x) {
        		if(words[i].equals((String.valueOf(alp)).trim())) {
        			sol++;
        		}
        	}
        }
        
        return sol;
    }
	
}
