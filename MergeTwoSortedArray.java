import java.util.Arrays;

public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int k = n+m -2;
       m = m-1;
       n = n-1;
      while (m >= 0 && n >= 0) {
          nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
      }
      
      while (n >= 0) {
          nums1[n] = nums2[n--];
      }
  }

}
