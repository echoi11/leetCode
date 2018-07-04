class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int pmax = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for(int i=1; i < nums.length; i++) {
            if(nums[i] > 0 ) {
                max = Math.max(nums[i], max*nums[i]); //
                min = Math.min(nums[i], min*nums[i]); //
            } else {
                pmax = max;
                max = Math.max(nums[i], min*nums[i]); //12,6
                min = Math.min(nums[i], pmax*nums[i]); //-3,-24
            }
            result = Math.max(result, max); //12
            System.out.println("max,min,result="+ max+","+min+","+result);
        }
        return result;
    }
}
