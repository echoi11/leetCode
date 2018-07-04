class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = Math.max(nums[0] * nums[1] * nums[2], nums[len -1] * nums[len -2] * nums[len -3]);
        max = Math.max(max, nums[0] * nums[1] * nums[len -1]);
        return Math.max(max, nums[0] * nums[len -1] * nums[len -2]);
    }
}
