class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = 1;
        while(i < nums.length - 1 && j < nums.length) {
            if(i==j) {
                j++;
            }
            if(nums[i] + k == nums[j]) {
                set.add(nums[i]);
                i++;
            } else if(nums[i] + k > nums[j]) {
                j++;
            } else {
                i++;
            }
        }
        return set.size();
    }
}
