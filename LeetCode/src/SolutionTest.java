import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void fourSum() {
        Solution solution = new Solution();
        int[] haha = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        List result = solution.fourSum(haha, 0);
        System.out.println(Arrays.toString(result.toArray()));
    }

    @Test
    void threeSumClosest() {
        Solution solution = new Solution();
        int[] haha = new int[]{-1, 2, 1, -4};
        int result = solution.threeSumClosest(haha, 1);
        System.out.println(result);

        int[] hh2 = new int[]{1, 1, -1, -1, 3};
        int res = solution.threeSumClosest(hh2, -1);
        System.out.println(res);
    }

    @org.junit.jupiter.api.Test
    void findKthLargest() {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int result = solution.findKthLargest(nums, 4);
        System.out.println(result); //4
        int[] nums2 = new int[]{3, 2, 1, 5, 6, 4};
        int result2 = solution.findKthLargest(nums2, 2);
        System.out.println(result2); //5
    }

    @Test
    void sortList() {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Solution solution = new Solution();
        ListNode result = solution.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}