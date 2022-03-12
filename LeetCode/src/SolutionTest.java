import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class SolutionTest {
    Solution solution = new Solution();


    @Test
    void midQuickSort() {
        int[] result = {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3};
        solution.midQuickSort(result, 0, result.length - 1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void sortedListToBST() {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Solution solution = new Solution();
        TreeNode result = solution.sortedListToBST(head);
        System.out.println(result.val);
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

    @Test
    void sortNums() {
        int[] arr = {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3};
        int[] result = solution.sortNums(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }
}