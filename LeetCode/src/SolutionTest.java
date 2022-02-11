import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void findKthLargest() {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int result = solution.findKthLargest(nums, 4);
        System.out.println(result); //4
        int[] nums2 = new int[]{3,2,1,5,6,4};
        int result2 = solution.findKthLargest(nums2, 2);
        System.out.println(result2); //5
    }

    @Test
    void sortAB() {
        String[] arr = new String[] {"A", "B", "A", "B"};
        Solution solution = new Solution();
        solution.sortAB(arr);
        System.out.println(Arrays.toString(arr));
    }
}