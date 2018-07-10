class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int n : nums) {
            if(s.contains(n)) s.remove(n);
            else s.add(n);
        }
        for(Integer n : s) {
            return n;
        }
        return 0;
    }
}
