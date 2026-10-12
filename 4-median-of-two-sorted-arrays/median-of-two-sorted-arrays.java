
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] arr = new int[n1 + n2];

        int i = 0, j = 0, x = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                arr[x++] = nums1[i++];
            } else {
                arr[x++] = nums2[j++];
            }
        }

        while (i < n1) {
            arr[x++] = nums1[i++];
        }

        while (j < n2) {
            arr[x++] = nums2[j++];
        }

        int k = arr.length;
        int m = k / 2;

        if (k % 2 == 0) {
            return (arr[m - 1] + (double) arr[m]) / 2;
        } else {
            return arr[m];
        }
    }
}
