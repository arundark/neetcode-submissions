class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorttedArray = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
               sorttedArray[k] = nums1[i];
               i++; 
            }
            else{
                sorttedArray[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m){
            sorttedArray[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n){
            sorttedArray[k] = nums2[j];
            j++;
            k++;
        }

        for(int l = 0 ; l < nums1.length; l++){
            nums1[l] = sorttedArray[l];
        }
    }
}