class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middleIndex = 0;
        int totalLength = nums1.length + nums2.length;
        boolean isLengthOdd = false;
        if(totalLength % 2 == 1) {
            isLengthOdd = true;
        }
        middleIndex = totalLength / 2;
        
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        
        while(i < middleIndex - 1 + (totalLength % 2)) {
            if(index1 >= nums1.length) {
                index2++;
            } else if(index2 >= nums2.length) {
                index1++;
            } else {
                if(nums1[index1] <= nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            i++;
        }
        int median = 0;
        if(isLengthOdd) {
            if(index1 >= nums1.length) {
                median = nums2[index2];
            } else if(index2 >= nums2.length) {
                median = nums1[index1];
            } else if(nums1[index1] < nums2[index2]) {
                median = nums1[index1];
            } else {
                median = nums2[index2];
            }
            return median * 1d;
        } else {
            // length is even
            i=0;
            while(i<2) {
                if(index1 >= nums1.length) {
                    median += nums2[index2];
                    index2++;
                } else if(index2 >= nums2.length) {
                    median += nums1[index1];
                    index1++;
                } else {
                    if(nums1[index1] <= nums2[index2]) {
                        median += nums1[index1];
                        index1++;
                    } else {
                        median += nums2[index2];
                        index2++;
                    }
                }
                i++;
            }
            return median / 2d;
        }

    }
}
