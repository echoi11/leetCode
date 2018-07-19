class Solution {
    public int arrayNesting(int[] nums) {
        int count = 0;
        int maxCount = 0;
        int num;
        int nextNum;
        for(int i=0; i < nums.length; i++) {
            num = i;
            do {
                nextNum = nums[num];
                if(nextNum > -1) {
                    nums[num] = -1;
                    count++;
                } else {
                    break;    
                }
                num = nextNum;
            } while(num > 0);
            maxCount = Math.max(maxCount, count);
            count = 0;
        }
        return maxCount;
        /*
        // Use the solution below if you can't change the input nums array
        HashSet<Integer> usedSet = new HashSet<Integer>();
        int i = 0 ;
        int num = nums[i];
        int count = 0;
        int maxCount = 0;
        while(!usedSet.contains(i) && (nums.length - usedSet.size() > maxCount)) {
            while(!usedSet.contains(num)) {
                usedSet.add(num);
                count++;
                num = nums[num];
            }
            maxCount = Math.max(maxCount, count);
            count = 0;
            while(i < nums.length && usedSet.contains(i)) {
                i++;
            }
            num = i;
        }        
        return maxCount;
        */
    }
}
