class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] neededMatches = new int[nums.length];
        int matchIndex = -1;
        for(int i=0; i < nums.length ; i++) {
            neededMatches[i] = target - nums[i];
            matchIndex = findMatch(neededMatches, nums[i], i);
            if(matchIndex > -1) {
                return new int[] {matchIndex, i};
            }
        }
        return new int[]{};
    }
    
    private int findMatch(int[] neededMatches, int candidateNum, int maxIndex) {
        for(int i=0; i < neededMatches.length && i < maxIndex; i++) {
            if(neededMatches[i] == candidateNum) {
                return i;
            }
        }
        return -1;
    }
}
