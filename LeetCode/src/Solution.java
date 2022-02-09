import java.util.Arrays;

public class Solution {

    //215. Kth Largest Element in an Array (Medium)
    // https://leetcode.com/problems/kth-largest-element-in-an-array/

    public int findKthLargest(int[] nums, int k) {
        // rule out corner cases
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] result = sortArrays(nums, 0, nums.length - 1);
        return result[k-1];
    }

    private int[] sortArrays(int[] nums, int l, int r){
        // base case
        if (r == l){
            int[] array = new int[]{nums[r]};
            return array;
        }

        // recursive steps
        int mid = (l + r)/2;
        int[] left = sortArrays(nums,l, mid);
        int[] right = sortArrays(nums, mid+1, r);

        return mergeArrays(left, right);
    }

    private int[] mergeArrays(int[] left, int[] right){
        int low = 0;  //pointer of left sub-array;
        int high = 0;  //pointer of right sub-array;
        int idx = 0; //index of the result array which will be returned;
        int[] result = new int[left.length + right.length];


        while (low < left.length && high < right.length){
            if (left[low]>right[high]){
                result[idx++] = left[low++];
            }else{
                result[idx++] = right[high++];
            }
        }

        if (low!=left.length){
            for (int i = low; i< left.length;i++){
                result[idx++] = left[i];
            }
        }

        if (high != right.length){
            for (int i = high; i<right.length;i++){
                result[idx++] = right[i];
            }
        }

//        System.out.println(Arrays.toString(result));
        return result;
    }
}