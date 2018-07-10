class Solution {
    public int missingNumber(int[] nums) {
        int[] n = new int[nums.length + 1];
        for(int i : nums) {
            n[i] = 1;
        }
        for(int i=0; i < n.length; i++) {
            if(n[i]==0) return i;
        }
        return 0;
    }
}
