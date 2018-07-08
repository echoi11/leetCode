class Solution {


	List<Integer> primes = new ArrayList<Integer>();
	int prefix = 0;
	boolean repeatLastDigit = false;
	
    public int primePalindrome(int N) {
    	
        if(N==1) return 2;

    	if(N==2||N==3||N==5||N==7||N==11) {
    		return N;
    	}
    	
    	// need to know the left hand side of number and whether to
    	// repeat the last digit of left hand side.
    	// e.g. if N = 131 then left hand side = 13, repeat = false;
    	String s = N + "";
    	if(s.length() % 2 ==0) {
    		repeatLastDigit = true;
    		prefix = Integer.parseInt(s.substring(0, s.length()/2));
    	} else {
    		repeatLastDigit = false;
    		prefix = Integer.parseInt(s.substring(0, s.length()/2 + 1));
    	}
    	
    	int p = N;
       	p = makePalindrome();
        while(true) {
        	if(p >= N && isPrime(p)) {
        		return p;
        	}
        	p = incrementPalindrome(p);
        }
    }

    public boolean isPrime(int N) {
    	for(int i=2; i*i <= N; i++) {
    		if(N%i==0) {
    			return false;
    		}
    	}
    	return true;
    }

    // get the next largest palindrome
    private int incrementPalindrome(int n) {
    	int len = String.valueOf(prefix).length();
    	int p = 0;
    	do {
        	prefix ++;
        	if(String.valueOf(prefix).length() > len) {
        		repeatLastDigit = !repeatLastDigit;
        		if(repeatLastDigit) {
        			prefix = prefix/10;
        		}
        		len++;
        	}
        	p = makePalindrome();
    	} while (p < n);
    	return p;
    }

    // return a palindrome number given the left hand half of the number.
    private int makePalindrome() {
    	String s = prefix + "";
    	int len = s.length();
    	char [] c;
    	if(repeatLastDigit) {
    		c = new char[len *2];
    	} else {
    		c = new char[len *2 -1];
    	}
    	for(int i=0; i < c.length; i++) {
    		if( i < len) {
    			c[i] = s.charAt(i);
    		} else {
    			if(repeatLastDigit) {
    				c[i] = c[2*len - i - 1];
    			} else {
    				c[i] = c[2*len - i - 2];
    			}
    		}
    	}
    	return Integer.parseInt(String.valueOf(c));
    }
}
