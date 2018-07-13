class Solution {
    TreeSet<Integer> set = new TreeSet<Integer>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger*(maxChoosableInteger+1) / 2;
        if(sum < desiredTotal) {
            return false;
        } else if(sum = desiredTotal) {
            return (maxChoosableInteger % 2) == 1;
        } else {
            
            if()
        }
    }
    
    private boolean canWin(int [] nums, boolean isPlayer1, int desiredTotal) {
        if(getMax(nums) >= desiredTotal) {
            return isPlayer1;
        } else {
            // return true if any canWin returns true
            // remove random number and call canWin
            canWin(nums, !isPlayer1, desiredTotal);
        }
                return true;
            }
        }
        
    }
}
